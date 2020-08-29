package Database;

import Database.Util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*
练习：需求：
1. 通过键盘录入用户名和密码
2. 判断用户是否登陆成功
 */
public class LoginExercise {
	public static void main(String[] args) {
		// 1. 键盘输入用户名和密码
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter username:");
		String username = scanner.nextLine();
		System.out.println("Please enter password:");
		String password = scanner.nextLine();
		// 2. 调用方法
		// boolean flag = new LoginExercise().login(username, password);
		boolean flag = new LoginExercise().loginPrepared(username, password);
		// 3. 判断结果
		if (flag) {
			System.out.println("登陆成功");
		} else {
			System.out.println("用户名或密码错误");
		}
	}

	public boolean login(String username, String password) {
		if (username == null || password == null) {
			return false;
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// 1. 获取连接
			connection = JDBCUtils.getConnection();
			// 2. 定义sql语句
			String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
			// 3. 获取执行sql的对象
			statement = connection.createStatement();
			// 4. 执行查询
			resultSet = statement.executeQuery(sql);
			// 5. 判断
			/*if (resultSet.next()) { // 如果有下一行返回true
				return true;
			} else {
				return false;
			}*/
			return resultSet.next(); // 如果有下一行返回true
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			// JDBCUtils.close(resultSet, statement, connection);
		}

		return false;
	}

	// 使用PreparedStatement 对象
	public boolean loginPrepared(String username, String password) {
		if (username == null || password == null) {
			return false;
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 1. 获取连接
			connection = JDBCUtils.getConnection();
			// 2. 定义sql语句
			String sql = "select * from user where username = ? and password = ?";
			// 3. 获取执行sql的对象
			preparedStatement = connection.prepareStatement(sql);
			// 给？赋值
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			// 4. 执行查询
			resultSet = preparedStatement.executeQuery();
			// 5. 判断
			/*if (resultSet.next()) { // 如果有下一行返回true
				return true;
			} else {
				return false;
			}*/
			return resultSet.next(); // 如果有下一行返回true
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}

		return false;
	}
}
