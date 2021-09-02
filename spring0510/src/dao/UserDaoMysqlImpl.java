package dao;

import model.User;

public class UserDaoMysqlImpl implements IUserDao{
    @Override
    public User getUserById(Integer id) {
        User u = new User();
        u.setId(id);
        u.setAge(18);
        u.setName("Mysql");
        return u;
    }
}
