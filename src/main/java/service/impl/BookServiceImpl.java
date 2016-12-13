package service.impl;


import dao.GenericDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookService;



/**
 * Created by Administrator on 2016/12/10 0010.
 */
@Service
public class BookServiceImpl extends GenericServiceImpl<Book,Integer> implements BookService {
    //    @Autowired
//    private BookDao bookDao;
//    public void create(Book book) {
//        bookDao.create(book);
//
//    }
//
//    public List<Book> queryAll() {
//        return bookDao.queryAll();
//    }
//
//    public Book search(int id) {
//        return bookDao.search(id);
//    }
//
//    public void modify(Book book) {
//        bookDao.modify(book);
//
//    }
//
//    public void remove(int id) {
//        bookDao.remove(id);
//
//    }
//______________________________________________________________________________________________________________


    @Autowired
  public BookServiceImpl(GenericDao<Book,Integer> genericDao) {
    super(genericDao);
}


}
