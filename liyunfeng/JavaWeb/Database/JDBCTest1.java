package Database;

import java.sql.*;

public class JDBCTest1 {
	public static void main(String[] args) throws Exception {
		// 1. 导入驱动jar 包
		// 2. 注册驱动
		// Class.forName("com.mysql.jdbc.Driver");
		// 因为idea会提示
		// Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
		// The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 3. 获取数据库连接对象
		Connection connection = DriverManager.getConnection("jdbc:mysql://139.224.82.209:3306/datagrip", "liyunfeng", "lyf");
		// 4. 定义一个sql语句
		// String sql = "SHOW TABLES";
		String sql = "update stu set stu_local = 1 where id = 3";
		// 5. 获取执行sql的对象
		Statement statement = connection.createStatement();
		// 6. 执行sql语句
		int count = statement.executeUpdate(sql);
		// 7. 处理结果
		System.out.println(count);
		// 8. 释放资源
		statement.close();
		connection.close();
	}
}
