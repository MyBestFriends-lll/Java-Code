package Database;

import Database.Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
事务操作
 */
public class JDBCTest3 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet resultSet = null;
		try {
			// 1. 获取连接
			connection = JDBCUtils.getConnection();
			// 开启事务
			connection.setAutoCommit(false);
			// 2. 定义sql语句
			// 2.1 Tom - 500
			String sql1 = "update account set money = money - ? where id = ?";
			// 2.2 Jerry + 500
			String sql2 = "update account set money = money + ? where id = ?";
			// 3. 获取执行sql语句对象
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement2 = connection.prepareStatement(sql2);
			// 4. 设置参数
			preparedStatement1.setDouble(1, 500);
			preparedStatement1.setInt(2, 1);

			preparedStatement2.setDouble(1, 500);
			preparedStatement2.setInt(2, 2);
			// 5. 执行sql语句
			preparedStatement1.executeUpdate();
			/*
				执行时候出现异常
				后面的代码就不会被执行，解决办法：开启事务管理
			int i = 3 / 0;
			 */
			preparedStatement2.executeUpdate();
			// 提交事务，如果没有任何异常
			connection.commit();
		} catch (SQLException throwables) {
			// 如果有任何异常都会进入catch
			// 事务回滚
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			throwables.printStackTrace();
		} finally {
			// 注：不合规范，作为演示
			JDBCUtils.close(preparedStatement1, connection);
			JDBCUtils.close(preparedStatement2, null);
		}
	}
}
