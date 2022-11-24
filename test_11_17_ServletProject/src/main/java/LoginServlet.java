import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理用户请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 判定用户名或者密码是否正确~~
        // 正常来说这个判定操作是要放到数据库中进行存取的.
        // 此处为了简单, 就直接在代码里写死了. 假设有效的用户名和密码是 "zhangsan", "123"
        if ("zhangsan".equals(username) && "123".equals(password)) { // 注意下面的写法, 这样子写可以避免 username 为空异常
            // 登陆成功
            // 创建会话, 并保存必要的身份信息
            HttpSession httpSession = req.getSession(true);
            // 往会话中存储键值对(必要的身份信息)
            httpSession.setAttribute("username", username);
            // 设置登录次数, 初始情况下, 登录次数为0
            httpSession.setAttribute("count", 0);
            // 重定向操作
            resp.sendRedirect("index");
        } else {
            // 登录失败
            resp.getWriter().write("login failed!");
        }
    }
}
