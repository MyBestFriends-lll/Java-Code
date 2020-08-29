package Database.Util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/*
JDBC 工具类
 */
public class JDBCUtils {
	// 把变量变成全局变量
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	// 读取配置文件，只需要读取一次即可，所以使用静态代码块
	static {
		try {
			// 1. 创建Properties 集合类
			Properties properties = new Properties();
			// 获取src路径下的文件的方式 ---> ClassLoader 类加载器
			/*ClassLoader classLoader = JDBCUtils.class.getClassLoader();
			// 获取文件的URL（统一资源标识符、统一资源定位符）
			URL res = classLoader.getResource("jdbc.properties");
			String path = res.getPath();
			System.out.println(path);*/
			// 2. 加载文件
			properties.load(new FileReader("./src/Database/jdbc.properties"));
			// properties.load(new FileReader(path));
			// 3. 获取数据，赋值
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			driver = properties.getProperty("driver");
			// 4. 注册驱动
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 问题：不想传入参数，比较麻烦。解决：使用配置文件
	/**
	 * 获取连接
	 * @return 连接对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	// 因为可能有多种情况需要释放，所以需要重载
	/**
	 * 释放资源
	 * @param statement
	 * @param connection
	 */
	public static void close(Statement statement, Connection connection) {
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

	/**
	 * 释放资源（重载形式）
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
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
