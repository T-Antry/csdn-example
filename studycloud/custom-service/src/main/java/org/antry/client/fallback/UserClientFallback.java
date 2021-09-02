package org.antry.client.fallback;

import org.antry.client.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public String doGet(Long id) {
        return "<div><h1>Feign出发熔断</h1><div>";
    }
}
