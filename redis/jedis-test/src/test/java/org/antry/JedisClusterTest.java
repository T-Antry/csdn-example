package org.antry;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class JedisClusterTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("192.168.200.135", 8001));
        jedisClusterNode.add(new HostAndPort("192.168.200.136", 8002));
        jedisClusterNode.add(new HostAndPort("192.168.200.137", 8003));
        jedisClusterNode.add(new HostAndPort("192.168.200.135", 8004));
        jedisClusterNode.add(new HostAndPort("192.168.200.136", 8005));
        jedisClusterNode.add(new HostAndPort("192.168.200.137", 8006));

        JedisCluster jedisCluster = null;
        try {
            //connectionTimeout：指的是连接一个url的连接等待时间
            //soTimeout：指的是连接上一个url，获取response的返回等待时间
            jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10, "antry", config);
            System.out.println(jedisCluster.set("cluster", "antry"));
            System.out.println(jedisCluster.get("cluster"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisCluster != null)
                jedisCluster.close();
        }

    }
}
