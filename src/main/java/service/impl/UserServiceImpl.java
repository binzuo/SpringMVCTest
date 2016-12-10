package service.impl;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public void create(User user) {
        userDao.create(user);

    }

    public User query(String statement, User user) {
        return userDao.query(statement,user);
    }

    public boolean register(User user) {
        if (userDao.query("user.queryUserByEmail",user)==null){
            userDao.create(user);
            return true;
        }else {
            return false;
        }
    }
}
