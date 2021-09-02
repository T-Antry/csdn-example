package org.antry.client;

import org.antry.client.fallback.UserClientFallback;
import org.antry.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//声明当前类是一个Feign客户端，指定服务名为user-service
@FeignClient(value = "user-service",fallback = UserClientFallback.class,configuration = FeignConfig.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    public String doGet(@PathVariable Long id);
}
