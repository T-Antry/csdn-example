package org.antry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName UserService
 * @Description 实现类
 * @Autor T_Antry
 * @Date 2020/11/11 11:26
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{

   @Override
   public String doGetUser(Long id){

       return "custom-Service回应：" +
               "<div><h1>T_Antry工作室-springcloud动手了解</h1></div>" +
               "customService[无中转]:"+String.valueOf(id);
   }
}

