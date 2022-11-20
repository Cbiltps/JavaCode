import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重点理解从请求中获取json格式数据的方式
 */
class User {
    // 当前这俩属性都设置成 public. 如果是设为 private, 但是同时提供了 getter setter , 效果等同的.
    public int userId;
    public int classId;
}

@WebServlet("/postJson")
public class PostJsonServlet extends HttpServlet {
    // 1: 创建一个jackson的核心对象
    // 这里建议写成成员变量, 方便后续方法使用针对一个对象
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 2: 读取 body 中的请求, 然后使用 ObjectMapper 来解析成需要的对象.
        // readValue 就是把 JSON 格式的字符串, 转成 Java 的对象
        // 第一个参数, 表示对哪个字符串进行转换. 这个参数可以填写成一个 String, 也可以填一个 InputStream 对象, 还可以填一个 File
        // 第二个参数, 表示要把这个 JSON 格式的字符串, 转成哪个 Java 对象
        User user = objectMapper.readValue(req.getInputStream(), User.class);
        resp.getWriter().write("userId: " + user.userId + ", classId: " + user.classId);
    }
}
