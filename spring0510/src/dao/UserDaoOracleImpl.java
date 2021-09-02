package dao;

import model.User;

public class UserDaoOracleImpl implements IUserDao{
    @Override
    public User getUserById(Integer id) {
        User u = new User();
        u.setId(id);
        u.setAge(17);
        u.setName("Oracle");
        return u;
    }
}
