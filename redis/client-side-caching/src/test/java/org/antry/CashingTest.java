package org.antry;


import io.lettuce.core.RedisClient;
import io.lettuce.core.TrackingArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.support.caching.CacheAccessor;
import io.lettuce.core.support.caching.CacheFrontend;
import io.lettuce.core.support.caching.ClientSideCaching;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class CashingTest {
    public static void main(String[] args) throws InterruptedException {
        RedisClient redisClient = RedisClient.create("redis://192.168.200.139");
        Map<String, String> clientCache = new ConcurrentHashMap<>();
        StatefulRedisConnection<String, String> myself = redisClient.connect();
        CacheFrontend<String, String> frontend =
                ClientSideCaching.enable(CacheAccessor.forMap(clientCache),
                myself,
                TrackingArgs.Builder.enabled().noloop());
        String key="csk";
        int count = 0;
        while (true){
            System.out.println(frontend.get(key));
            TimeUnit.SECONDS.sleep(3);
            if (count++ == Integer.MAX_VALUE){
                myself.close();
                redisClient.shutdown();
                }
            }
    }
}
