package Database;

import Database.Util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
ResultSet 遍历结果集
 */
public class JDBCTest4 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// 1. 获取连接
			connection = JDBCUtils.getConnection();
			// 2. 定义sql语句
			String sql = "select * from account";
			// 3. 获取执行sql语句对象
			statement = connection.createStatement();
			// 4. 执行sql语句
			resultSet = statement.executeQuery(sql);
			// 5. 处理结果
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double money = resultSet.getDouble("money");
				System.out.println(id + " -> " + name + " -> " + money);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, statement, connection);
		}
	}
}
