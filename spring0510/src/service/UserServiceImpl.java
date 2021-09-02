package service;

import dao.IUserDao;
import dao.UserDaoMysqlImpl;
import dao.UserDaoOracleImpl;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements IUserService{
    /**
     * 使用Oracle时
     */
    private IUserDao dao ;

    public IUserDao getDao() {
        return dao;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public void getUser() {
        User u = dao.getUserById(18);
        System.out.println(u);
    }
}
