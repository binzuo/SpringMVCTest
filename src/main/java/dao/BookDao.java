package dao;

import model.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/12/10.
 */
public interface BookDao {
    void add(Book book) ;
    List<Book> query();

    Book search(int id);

    void update(Book book);

    void remove(int id);
}
