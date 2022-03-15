import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class TestJDBC {
    public static void main(String[] args) {
        //这是JDBC带的接口          这个是MySQL带的驱动包
        DataSource dataSource = new MysqlDataSource();// 这里向上转型
        // 设置数据库所在的地址
        ((MysqlDataSource)dataSource).setURL();
    }
}
