package Database.dataSource.JdbcTemplate;

import Database.Util.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/*
JdbcTemplate 入门
 */
public class JdbcTemplateTest1 {
	public static void main(String[] args) {
		// 1. 导入jar包
		// 2. 创建JDBCTemplate 对象
		JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());
		// 3. 调用方法
		String sql = "update account set money = 50000 where id = ?";
		int count = template.update(sql, 3);
		System.out.println(count);
	}
}
