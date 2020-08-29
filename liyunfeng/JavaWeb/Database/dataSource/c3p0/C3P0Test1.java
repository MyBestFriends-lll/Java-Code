package Database.dataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
c3p0 使用演示
 */
public class C3P0Test1 {
	public static void main(String[] args) throws SQLException {
		// 1. 创建数据库连接池对象
		DataSource ds = new ComboPooledDataSource();
		// 2. 获取连接对象
		Connection connection = ds.getConnection();
		// 3. 打印连接对象
		System.out.println(connection);
	}
}
