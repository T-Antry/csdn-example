package org.antry.service.impl;
import org.antry.model.User;
import org.antry.service.UserService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
@Service
@WebService
public class UserServiceImpl implements UserService {
    @Override
    public String showUser(Integer id) {
        User u = new User();
        u.setId(id);
        u.setAge(15);
        u.setName("antry");
        u.setSex(true);
        u.setHobbies("boy");
        u.setExtend("have a lot of money");
        return u.toString();
    }
}
