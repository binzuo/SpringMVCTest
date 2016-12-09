package controller;

import model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {
    @Autowired
    private SqlSession sqlSession;
    @RequestMapping("add")
    private String add(Book book){
        sqlSession.insert("book.add",book);
        return"/book/query";
    }
    @RequestMapping("query")
    private String query(Book book){
        List<Book> books=sqlSession.selectList("book.query",book);
        request.getSession().setAttribute("books",books);
        return "redirect:/home.jsp";
    }


}
