package service.impl;


import dao.GenericDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
@Service
public class GenericServiceImpl <T> implements GenericDao<T> {

    private GenericDao<T> genericDao;

    public GenericServiceImpl(GenericDao<T> genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public void create(T t) {
        genericDao.create(t);
    }

    @Override
    public List<T> queryAll() {
        return genericDao.queryAll();
    }

    @Override
    public T search(int id) {
        return genericDao.search(id);
    }

    @Override
    public void modify(T t) {
        genericDao.modify(t);

    }

    @Override
    public void remove(int id) {
        genericDao.remove(id);

    }
}
