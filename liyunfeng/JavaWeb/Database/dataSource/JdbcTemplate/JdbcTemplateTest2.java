package Database.dataSource.JdbcTemplate;

import Database.Util.DataSourceUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest2 {
	// 1. 获取JDBCTemplate 对象
	private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());

	// 使用Junit单元测试
	// 1. 修改1号数据的money为4567（account表）
	@Test
	public void test1() {
		// 2. 定义sql语句
		String sql = "update account set money = 4567 where id = ?";
		// 3. 执行sql语句
		int count = template.update(sql, 1);
		System.out.println(count);
	}
	// 2. 添加一条记录
	@Test
	public void test2() {
		String sql = "insert account(id, name, money) values(?, ?, ?)";
		int count = template.update(sql, 4, "xm", 200);
		System.out.println(count);
	}
	// 3. 删除刚才添加的记录
	@Test
	public void test3() {
		String sql = "delete from account where id = ?";
		int count = template.update(sql, 4);
		System.out.println(count);
	}
	// 4. 查询id为1的记录，将其封装为Map集合
	// 注意：这个方法查询的结果集长度只能是1,两条记录会报错
	@Test
	public void test4() {
		String sql = "select * from account where id = ?";
		Map<String, Object> map = template.queryForMap(sql, 1);
		System.out.println(map); // {id=1, name=Tom, money=4567.0}
	}
	// 5. 查询所有记录，将其封装为List
	@Test
	public void test5() {
		String sql = "select * from account";
		List<Map<String, Object>> list = template.queryForList(sql);
		list.forEach(stringObjectMap -> System.out.println(stringObjectMap));
		/*for (Map<String, Object> stringObjectMap : list) {
			System.out.println(stringObjectMap);
		}*/
	}
	// 6. 查询所有记录，将其封装为xxx对象的List集合
	@Test
	public void test6() {
		String sql = "select * from account";
		List<Account> list = template.query(sql, new RowMapper<Account>() {
			@Override
			public Account mapRow(ResultSet resultSet, int i) throws SQLException {
				Account account = new Account();
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double money = resultSet.getDouble("money");

				account.setId(id);
				account.setName(name);
				account.setMoney(money);
				return account;
			}
		});
		for (Account account : list) {
			System.out.println(account);
		}
	}
	// 6. 查询所有记录，将其封装为xxx对象的List集合
	// 使用Spring JDBC提供的类简化操作
	@Test
	public void test6_2() {
		String sql = "select * from account";
		// 注意：基本数据类型不能接收null，应该使用引用数据类型
		List<Account> list = template.query(sql, new BeanPropertyRowMapper<>(Account.class));
		// List<Account> list = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
		for (Account account : list) {
			System.out.println(account);
		}
	}
	// 7. 查询总记录数（count函数）
	@Test
	public void test7() {
		String sql = "select count(id) from account";
		Long total = template.queryForObject(sql, Long.class);
		System.out.println(total);
	}
}
