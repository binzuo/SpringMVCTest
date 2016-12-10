package service;

import model.User;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
public interface UserService {
    void create(User user);

    User query(String statement, User user);
    boolean register(User user);

}
