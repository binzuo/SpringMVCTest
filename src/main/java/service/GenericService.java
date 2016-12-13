package service;



import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
public interface GenericService<T extends Serializable,ID extends Serializable> {
    void create(T t) ;
    List<T> queryAll();
    T query(String statement, Object parameter);

    List<T> queryList(String statement, Object parameter);

    T search(ID id);

    void modify(T t);

    void remove(ID id);
}
