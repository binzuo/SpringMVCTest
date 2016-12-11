package service;



import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
public interface GenericService<T> {
    void create(T t) ;
    List<T> queryAll();

    T search(int id);

    void modify(T t);

    void remove(int id);
}
