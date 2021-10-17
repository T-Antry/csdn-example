package org.antry.test;

import org.antry.service.impl.UserServiceImpl;
import org.antry.service.impl.UserServiceImplService;

/**
 * @author: T_Antry
 * @date: 2021/10/17 17:55
 * @description:生成客户端调用方式
 */
public class ClientTest {
    public static void main(String[] args) {
        //创建服务视图，视图是从wsdl文件的service标签的name属性获取
        UserServiceImplService service = new UserServiceImplService();
        //获取服务实现类，实现类从wsdl文件的portType的name属性获取
        UserServiceImpl impl = service.getPort(UserServiceImpl.class);
        //获取查询方法，从portType的operation标签获取
        String s = impl.showUser(1);
        System.out.println(s);
    }
}
