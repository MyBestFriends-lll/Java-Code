package Database.dataSource.Druid;

import Database.Util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
使用数据库连接池工具类
 */
public class DruidTest2 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1. 获取连接
			connection = DataSourceUtils.getConnection();
			// 2. 定义sql语句
			String sql = "insert account values(3, ?, ?)";
			// 3. 获取执行sql语句的对象
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Miffy");
			preparedStatement.setDouble(2, 300);
			// 4. 执行sql语句
			int count = preparedStatement.executeUpdate();
			System.out.println(count);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			DataSourceUtils.close(preparedStatement, connection);
		}
	}
}
