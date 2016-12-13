package dao.impl;

import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/10.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements UserDao {
//    @Autowired
//    private SqlSession sqlSession;
//
//    public void create(User user) {
//        sqlSession.insert("user.create",user);
//
//    }
//    public User query(String statement,User user) {
//        return sqlSession.selectOne(statement,user);
//    }

}
