package Database;

import java.sql.*;

public class JDBCTest2 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			// 1. 注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 定义sql语句
			String sql = "insert stu values(null, 'aaa', 2)";
			// 3. 获取Connection 对象
			connection = DriverManager.getConnection("jdbc:mysql://139.224.82.209:3306/datagrip", "liyunfeng", "lyf");
			// 4. 获取执行sql的对象
			statement= connection.createStatement();
			// 5. 执行sql语句
			int count = statement.executeUpdate(sql); // 影响的行数
			// 6. 处理结果
			System.out.println(count);
			if (count > 0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 7. 释放资源
			// statement.close();
			// 避免空指针异常，做判断
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
	}
}
