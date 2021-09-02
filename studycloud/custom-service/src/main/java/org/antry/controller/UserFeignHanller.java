package org.antry.controller;

import org.antry.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/feign")
public class UserFeignHanller {
    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public String doGet(@PathVariable Long id){
        return "<div><h1>通过Feign去调用</h1><div>"+ userClient.doGet(id);
    }
}
