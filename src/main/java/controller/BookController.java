package controller;

import dao.BookDao;
import model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {
   // @Autowired
   // private SqlSession sqlSession;
    @Autowired
    //@Qualifier("bookDaoJdbcImpl")
    private BookDao bookDao;
    @RequestMapping("add")
    private String add(Book book){
        //sqlSession.insert("book.add",book);
        bookDao.add(book);

        return"redirect:/book/query";
    }
    @RequestMapping("query")
    private String query(){
        //request.getSession().setAttribute("books",sqlSession.selectList("book.query"));
        request.getSession().setAttribute("books",bookDao.query());
        return "redirect:/home.jsp";
    }
    @RequestMapping("search/{id}")
    private String search(@PathVariable int id){
        //request.getSession().setAttribute("book",sqlSession.selectOne("book.search",id));
        request.getSession().setAttribute("book",bookDao.search(id));
        return "redirect:/edit.jsp";
    }
    @RequestMapping("update")
    private String update(Book book){
        //sqlSession.update("book.update",book);
        bookDao.update(book);
        return"redirect:/book/query";

    }
    @RequestMapping("remove/{id}")
    private String remove(@PathVariable int id){
        //sqlSession.delete("book.remove",id);
        bookDao.remove(id);
        return"redirect:/book/query";

    }


}
