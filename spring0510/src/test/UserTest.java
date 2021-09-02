package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.UserServiceImpl;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        IUserService service = ioc.getBean(IUserService.class);
        service.getUser();
    }
}
