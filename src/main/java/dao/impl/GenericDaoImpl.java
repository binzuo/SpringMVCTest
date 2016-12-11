package dao.impl;
import dao.GenericDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
public class GenericDaoImpl<T>  implements GenericDao<T> {
    private String namespace; // 对应于 mapper 中 namespace 的值

    @Autowired
    private SqlSession sqlSession;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
//        System.out.println("a: " + getClass());
//        System.out.println("b: " + getClass().getGenericSuperclass());
//        System.out.println("c: " + ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        Class<T> clazz = (Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
//        System.out.println("d: " + clazz);
//        System.out.println("e: " + clazz.getSimpleName());
        namespace = clazz.getSimpleName().toLowerCase().concat(".");
    }



    public void create(T t) {
        sqlSession.insert(namespace.concat("add"), t);

    }

    public List<T> queryAll() {
        return sqlSession.selectList(namespace.concat("query"));
    }

    public T search(int id) {
        return sqlSession.selectOne(namespace.concat("search"),id);
    }

    public void modify(T t) {
        sqlSession.update(namespace.concat("update"),t);

    }

    public void remove(int id) {
        sqlSession.delete(namespace.concat("remove"),id);

    }
}
