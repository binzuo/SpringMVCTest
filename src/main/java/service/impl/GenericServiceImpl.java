package service.impl;


import dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.GenericService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
public class GenericServiceImpl <T extends Serializable,ID extends Serializable> implements GenericService<T,ID> {


    public GenericDao<T,ID> genericDao;

    public GenericServiceImpl(GenericDao<T,ID> genericDao) {
        this.genericDao = genericDao;
    }

    public void create(T t) {
        genericDao.create(t);

    }

    public List<T> queryAll() {
        return genericDao.queryAll();
    }

    @Override
    public T query(String statement, Object parameter) {
        return genericDao.query(statement,parameter);
    }

    @Override
    public List<T> queryList(String statement, Object parameter) {
        return null;
    }

    public T search(ID id) {
        return genericDao.search(id);
    }

    public void modify(T t) {
        genericDao.modify(t);

    }

    public void remove(ID id) {
        genericDao.remove(id);

    }
}
