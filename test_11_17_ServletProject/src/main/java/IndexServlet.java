import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 返回一个主页. (主页就是一个简单的 html 片段)
        // 此处需要得到用户名是啥, 从 HttpSession 中就能拿到.
        // 此处 getSession 的参数必须是 false. 前面在登录过程中, 已经创建过会话了. 此处是要直接获取到之前的会话.
        HttpSession httpSession = req.getSession(false);
        // 从 httpSession 依据 key 拿到 value(username)
        String username = (String) httpSession.getAttribute("username");

        // 从会话中取出 count
        Integer integerCount = (Integer) httpSession.getAttribute("count");
        integerCount += 1;
        // 把自增之后的值写回到会话中
        httpSession.setAttribute("count", integerCount);

        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("<h3>欢迎" + username + "第" + integerCount + "次访问!</h3>");
    }
}
