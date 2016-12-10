package dao;

import model.User;

/**
 * Created by Administrator on 2016/12/10.
 */
public interface UseDao {
    void create(User user);
    User login(User user);

}
