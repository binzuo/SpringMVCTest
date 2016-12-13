package service;

import model.User;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
public interface UserService extends GenericService<User,Integer>{
    boolean register(User user);

}
