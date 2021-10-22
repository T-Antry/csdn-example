package org.antry;

import org.antry.model.OtherUser;
import org.antry.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class SpringBeanTest
{
    public static void main( String[] args )
    {
        System.out.println("************************************************现在开始初始化容器************************************************");
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        System.out.println("**************************************************容器初始化成功**************************************************");
        System.out.println("【第四步】: 获取创建好的bean实例对象");
        User user = ioc.getBean("user", User.class);
      //  OtherUser otherUser = ioc.getBean(OtherUser.class);

        System.out.println(user.getName());
      //  System.out.println(otherUser.getName());
        System.out.println("*************************************************现在开始关闭容器*************************************************");
        ioc.registerShutdownHook();
    }
}
