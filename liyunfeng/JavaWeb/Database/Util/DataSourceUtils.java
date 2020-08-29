package Database.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
数据库连接池(Druid)的工具类
 */
public class DataSourceUtils {
	// 1. 定义成员变量 DataSource
	private static DataSource ds;
	static {
		try {
			// 1. 加载配置文件
			Properties properties = new Properties();
			properties.load(new FileReader("./src/Database/dataSource/Druid/druid.properties"));
			// 2. 获取DataSource
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接的方法
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

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
				connection.close(); // 归还连接
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
		/*if (statement != null) {
			try {
				statement.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close(); // 归还连接
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}*/
		close(statement, connection);
	}

	/**
	 * 获取连接池的方法
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}
}
