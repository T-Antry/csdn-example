package org.antry;

import jdk.nashorn.internal.runtime.options.OptionTemplate;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.List;

public class JedisTest {
    private JedisPool jedisPool;

    @Before
    public void before(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);
        // timeout，这里既是连接超时又是读写超时，从Jedis 2.8开始有区分connectionTimeout和soTimeout的构造函数
        jedisPool = new JedisPool(jedisPoolConfig, "192.168.200.139", 6379, 3000, null);
    }
    @Test
    public void test1() {
        Jedis jedis = null;
        //******* jedis普通操作示例 ********
        try {
            //从redis连接池里拿出一个连接执行命令
            jedis = jedisPool.getResource();
            //******* jedis普通操作示例 ********
            System.out.println(jedis.set("antry", "antry"));
            System.out.println(jedis.get("antry"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis!=null)
                jedis.close();
        }

    }

    @Test
    public void testPipeline(){

        //******* 管道示例 ********
        //管道的命令执行方式：cat redis.txt | redis-cli -h 127.0.0.1 -a password - p 6379 --pipe
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();
            for (int i = 0; i < 10; i++) {
                pl.incr("pipelineKey");
                pl.set("zhuge" + i, "zhuge");
                //模拟管道报错
                //pl.setbit("zhuge", -1, true);
            }
            List<Object> results = pl.syncAndReturnAll();
            System.out.println(results);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    @Test
    public void  testLua(){
        //******* lua脚本示例 ********
        //模拟一个商品减库存的原子操作
        //lua脚本命令执行方式：redis-cli --eval /tmp/test.lua , 10
        Jedis jedis = null;
        //从redis连接池里拿出一个连接执行命令
        try {
            jedis = jedisPool.getResource();
            jedis.set("product_stock_10016", "15");  //初始化商品10016的库存
            String script = " local count = redis.call('get', KEYS[1]) " +
                    " local a = tonumber(count) " +
                    " local b = tonumber(ARGV[1]) " +
                    " if a >= b then " +
                    "   redis.call('set', KEYS[1], a-b) " +
                    //模拟语法报错回滚操作
                    //"   bb == 0 " +
                    "   return 1 " +
                    " end " +
                    " return 0 ";
            Object obj = jedis.eval(script, Arrays.asList("product_stock_10016"), Arrays.asList("10"));
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis!=null)
                jedis.close();
        }
    }
}
