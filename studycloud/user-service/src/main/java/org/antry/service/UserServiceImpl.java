package org.antry.service;

import org.springframework.stereotype.Service;

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
//       try {
//           Thread.sleep(2000);
//       } catch (InterruptedException e) {
//           e.printStackTrace();
//       }
       return "<div><h2>User-Service回应：</h2></div>" +
               "<div><h1>T_Antry工作室-springcloud动手了解</h1></div>" +
               "userService:"+String.valueOf(id);
   }
}