package service;

import model.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
public interface BookService {
    void create(Book book) ;
    List<Book> queryAll();

    Book search(int id);

    void modify(Book book);

    void remove(int id);
}
