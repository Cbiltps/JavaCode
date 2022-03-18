import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        // 1：创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_102?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("xiangzi");

        // 2：建立链接
        Connection connection = dataSource.getConnection();

        // 3：拼装 SQL
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 4：执行SQL

        /*对于查询操作使用的就是executeQuery了，前面的executeUpdate，返回的是int，这里返回的就是一个“临时表”了,
        * 这里使用的是ResultSet来表示这个表！*/
        ResultSet resultSet = statement.executeQuery();



        // 5：遍历返回的集合（临时表），先获取每一行，然后获取这一行的若干列

        /*next方法表示获取到一行记录，同时把光标往后移动一行，
        * 如果遍历带表的结束位置，此处的next直接返回false！*/
        while (resultSet.next()) {
            //针对当前的一行来获取到其中的一列
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id:" + id + " " + "name:" + name);
        }

        // 6：释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
