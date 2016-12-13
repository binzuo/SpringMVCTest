package service.impl;

import dao.GenericDao;
import dao.UserDao;
import dao.impl.GenericDaoImpl;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GenericService;
import service.UserService;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User,Integer> implements UserService {
//    @Autowired
//    private UserDao userDao;
//    public void create(User user) {
//        userDao.create(user);

//    }

//    public User query(String statement, User user) {
//        return userDao.query(statement,user);
//    }

//____________________________________________________________________________

    @Autowired
    public UserServiceImpl(GenericDao<User, Integer> genericDao) {
           super(genericDao);
    }
    @Override
    public boolean register(User user) {
        if (genericDao.query("user.queryUserByEmail",user)==null){
            genericDao.create(user);
            return true;
        }else {
            return false;
        }

    }

}
