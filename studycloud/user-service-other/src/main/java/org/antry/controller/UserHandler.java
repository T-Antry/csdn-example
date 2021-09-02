package org.antry.controller;

import org.antry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserHandler
 * @Description TODO
 * @Autor T_Antry
 * @Date 2020/11/11 11:32
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserHandler {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public String doGet(@PathVariable Long id){
        return userService.doGetUser(id);
    }
}