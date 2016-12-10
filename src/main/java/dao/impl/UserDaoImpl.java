package dao.impl;

import dao.UseDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/10.
 */
@Repository
public class UserDaoImpl implements UseDao {
    @Autowired
    private SqlSession sqlSession;
    public void create(User user) {
        sqlSession.insert("user.create",user);

    }

    @Override
    public User login(User user) {
        return sqlSession.selectOne("user.login", user);
    }
}
