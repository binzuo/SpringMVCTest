package controller;

import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Administrator on 2016/12/3 0003.
 */
@Controller
@RequestMapping("user") // @WebServlet(urlPatterns = "/user")
public class UserController extends BaseController {
    @Autowired
    private SqlSession sqlSession;
    @RequestMapping("create")
    private String create(User user) {
        sqlSession.insert("user.create",user);
        return "redirect:/index.jsp";
    }
    @RequestMapping("login")
    private String login(User user) {
            user=sqlSession.selectOne("user.login",user);
            if (user!=null){
                session.setAttribute("user","欢迎您"+user.getEmail());
                return "redirect:/home.jsp";
            }else {
                session.setAttribute("warning","您输入的账号或密码不正确");
                return "/index.jsp";
            }



    }
    @RequestMapping("logout")
    private String logout(){
        session.invalidate();
        return "redirect:/index.jsp";
    }


}
