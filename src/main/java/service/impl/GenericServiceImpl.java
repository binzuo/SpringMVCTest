package service.impl;


import dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.GenericService;

import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
public class GenericServiceImpl <T> implements GenericService<T> {


    private GenericDao<T> genericDao;

    public GenericServiceImpl(GenericDao<T> genericDao) {
        this.genericDao = genericDao;
    }

    public void create(T t) {
        genericDao.create(t);

    }

    public List<T> queryAll() {
        return genericDao.queryAll();
    }

    public T search(int id) {
        return genericDao.search(id);
    }

    public void modify(T t) {
        genericDao.modify(t);

    }

    public void remove(int id) {
        genericDao.remove(id);

    }
}
