package org.antry;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Unit test for simple App.
 */
public class BllomTest
{
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.200.139:6379");
        //构造Redisson
        RedissonClient redisson = Redisson.create(config);
        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("nameList");
        //初始化布隆过滤器：预计元素为100000000L,误差率为3%,根据这两个参数会计算出底层的bit数组大小
        bloomFilter.tryInit(100000L,0.03);
        //将zhuge插入到布隆过滤器中
        bloomFilter.add("antry");
        bloomFilter.add("niuniu");

        //判断下面号码是否在布隆过滤器中
        System.out.println(bloomFilter.contains("guojia"));//false
        System.out.println(bloomFilter.contains("niuniu"));//true
        System.out.println(bloomFilter.contains("antry"));//true
    }
}
