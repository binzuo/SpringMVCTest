package controller;
import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

/**
 * Created by Administrator on 2016/12/3 0003.
 */
@Controller
@RequestMapping("user") // @WebServlet(urlPatterns = "/user")
public class UserController extends BaseController {
//    @Autowired
//    private SqlSession sqlSession;
//-----------------------------------------------------------
//    @Autowired
//    private UserDao userDao;
//-----------------------------------------------------------
    @Autowired
    private UserService userService;
//_____________________________________________________________
    @RequestMapping("create")
    private String create(User user) {
//        sqlSession.insert("user.create",user);
//------------------------------------------------------------
//        if (userDao.query("user.queryUserByEmail",user)==null){
//            userDao.create(user);
//            return "redirect:/index.jsp";
//        }
//        request.setAttribute("prompt","账号已经注册，请直接登录");
//         return "/signup.jsp";
//------------------------------------------------------------
        if (userService.register(user)){
            return "redirect:/index.jsp";
        }
        request.setAttribute("prompt","账号已经注册，请直接登录");
        return "/signup.jsp";
    }
//_______________________________________________________________
    @RequestMapping("login")
    private String login(User user) {
//        user=sqlSession.selectOne("user.login",user);
//--------------------------------------------------------------
//        user= userDao.query("user.login",user);
//--------------------------------------------------------------
        user=userService.query("user.login",user);
//_______________________________________________________________
            if (user!=null){
                session.setAttribute("user","欢迎您"+user.getEmail());
                return "/book/queryAll";
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
