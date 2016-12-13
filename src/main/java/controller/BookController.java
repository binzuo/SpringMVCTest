package controller;

import dao.BookDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {
//    @Autowired
//    private SqlSession sqlSession;
//---------------------------------------------------------
//    @Autowired
//    @Qualifier("bookDaoJdbcImpl")
//    private BookDao bookDao;
//---------------------------------------------------------------
    @Autowired
    private BookService bookService;
//______________________________________________________________
    @RequestMapping("create")
    private String create(Book book){
//        sqlSession.insert("book.add",book);
//---------------------------------------------------
//        bookDao.create(book);
//----------------------------------------------------
        bookService.create(book);
//____________________________________________________________
        return"redirect:/book/queryAll";
    }
    @RequestMapping("queryAll")
    private String queryAll(){
//        request.getSession().setAttribute("books",sqlSession.selectList("book.query"));
//---------------------------------------------------------------------------------------
//        request.getSession().setAttribute("books",bookDao.queryAll());
//-----------------------------------------------------------------------------------------
        request.getSession().setAttribute("books",bookService.queryAll());
//______________________________________________________________________________________-
        return "redirect:/home.jsp";
    }
    @RequestMapping("search/{id}")
    private String search(@PathVariable int id){
//        request.getSession().setAttribute("book",sqlSession.selectOne("book.search",id));
//---------------------------------------------------------------------------------------------------
//        request.getSession().setAttribute("book",bookDao.search(id));
//---------------------------------------------------------------------------
        request.getSession().setAttribute("book",bookService.search(id));
//__________________________________________________________________________________
        return "redirect:/edit.jsp";
    }
    @RequestMapping("modify")
    private String modify(Book book){
//        sqlSession.update("book.update",book);
//--------------------------------------------------------------
//        bookDao.modify(book);
//---------------------------------------------------------------
        bookService.modify(book);
//________________________________________________________________-
        return"redirect:/book/queryAll";

    }
    @RequestMapping("remove/{id}")
    private String remove(@PathVariable int id){
//        sqlSession.delete("book.remove",id);
//-------------------------------------------------------------------
//        bookDao.remove(id);
//----------------------------------------------------------------------
        bookService.remove(id);
//___________________________________________________________________________-
        return"redirect:/book/queryAll";

    }


}
