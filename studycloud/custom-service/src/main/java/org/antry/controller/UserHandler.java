package org.antry.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javafx.beans.DefaultProperty;
import org.antry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * @ClassName UserHandler
 * @Description TODO
 * @Autor T_Antry
 * @Date 2020/11/11 11:32
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
@DefaultProperties(defaultFallback = "defaultFallback")
public class UserHandler {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/{id}")
    @HystrixCommand
    public String doGet(@PathVariable Long id){
//       String url = "http://127.0.0.1:1001/user/"+id;
//       return "<div><h1>custom-Service回应：</h1><div>"+restTemplate.getForObject(url, String.class);
//       return userService.doGetUser(id);
//         List<ServiceInstance> serviceInstances= discoveryClient.getInstances("user-service");
//         String url = "http://"+serviceInstances.get(0).getHost()+":"+serviceInstances.get(0).getPort()+"/user/"+id;
        /**
         * 模拟id=1时目标服务器异常。
         */
        if(1==id){
            throw new RuntimeException("要访问的服务器异常");
        }
         String url = "http://user-service/user/"+id;
        return "<div><h1>custom-Service[通过注册中心拉取服务]回应：</h1><div>"+restTemplate.getForObject(url, String.class);
    }
    /**
     * 检测到doGet异常时，会跳到这里来
     * @return
     */
    public String defaultFallback(){
        return "默认提示：要访问的服务器异常！";
    }

}