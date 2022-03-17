import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        /**
         * 第一步：创建号数据源
         */
        // 这是JDBC带的接口         这个是MySQL带的驱动包
        DataSource dataSource = new MysqlDataSource();// 这里向上转型
        // 设置数据库所在的地址 URL
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_102?characterEncoding=utf8&useSSL=false");
        // 设置登录数据库的用户名
        ((MysqlDataSource)dataSource).setUser("root");
        // 设置登录数据库的密码
        ((MysqlDataSource)dataSource).setPassword("xiangzi");

          //注意这样写完全可以的 区别看汤神笔记 有区别的 建议上面的
//        MysqlDataSource mysqlDataSource = new MysqlDataSource();
//        mysqlDataSource.setURL();
//        mysqlDataSource.setUser();
//        mysqlDataSource.setPassword();

        /**
         * 第二步：让代码和数据库服务器连接
         */
        Connection connection = dataSource.getConnection();

        /**
         * 第三步：数据库操作，已插入为例
         * 其关键就是构造一个SQL语句！
         */
        // 此处光是一个 String 类型的 sql 还不行, 需要把这个 String 包装成一个 "语句对象"
//        String sql = "insert into student values(1, '张三')";
        String sql = "insert into student values(?, ?)";

        //或者这里可以通过控制台输入
        System.out.println("请输入学号: ");
        int id = scanner.nextInt();
        System.out.println("请输入姓名: ");
        String name = scanner.next();

        PreparedStatement statement = connection.prepareStatement(sql);
        // 进行替换操作
        statement.setInt(1, id);
        statement.setString(2, name);
        System.out.println("statement:"+statement);// 打印日志

        /**
         * 第四步：执行 SQL
         */
        // SQL 里面如果是 insert, update, delete, 都使用 executeUpdate 方法.
        // SQL 里面如果是 select, 则使用 executeQuery 方法.
        int ret = statement.executeUpdate();// 返回值就表示这个操作, 影响到了几行. 就相当于在控制台里输入sql之后, 得到的数字~
        System.out.println(ret);

        /**
         * 第五步：此时 SQL 已经执行完毕. 然后还需要释放资源
         */
        statement.close();
        connection.close();
    }
}
