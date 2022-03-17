import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        // 删除数据库中的记录~
        // 让用户输入一个id 根据id来删除

        // 1. 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_102?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("xiangzi");

        // 2. 建立连接
        Connection connection = dataSource.getConnection();

        // 3. 用户输入 id
        Scanner scanner = new Scanner(System.in);
        System.out.printf("请输入一个要删除的 id: ");
        int id = scanner.nextInt();

        // 4. 拼装 sql 语句
        String sql = "delete from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println("statement:"+statement);

        // 5. 执行 sql
        int ret = statement.executeUpdate();
        System.out.println("ret = " + ret);

        // 6. 回收释放资源
        statement.close();
        connection.close();
    }
}