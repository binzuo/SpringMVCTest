package controller;

import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.MyBatisSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by Administrator on 2016/12/3 0003.
 */
@Controller
@RequestMapping("user") // @WebServlet(urlPatterns = "/user")
public class UserController{
    @RequestMapping("signUp")
    private void signUp(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password =req.getParameter("password");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("user.create",new model.User(null,email,password));
        }


        req.getSession().setAttribute("congratulation","恭喜您注册成功!");
        try {
            resp.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("login")
    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            List<User> users=sqlSession.selectList("user.login",new model.User(null,email,password));
            if (users.size()>0){
                try {
                    req.getSession().setAttribute("welcome","欢迎您:"+email);
                    req.getSession().setAttribute("email",email);
                    resp.sendRedirect("/home.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    req.getSession().setAttribute("warning","您输入的账号或密码不正确!");
                    resp.sendRedirect("/index.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @RequestMapping("logout")
    private void logout(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getSession().invalidate();
            resp.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
