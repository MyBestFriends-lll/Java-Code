package Database.dataSource.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/*
Druid 演示
 */
public class DruidTest1 {
	public static void main(String[] args) throws Exception {
		// 1. 导入jar包
		// 2. 定义配置文件
		// 3. 加载配置文件
		Properties properties = new Properties();
		properties.load(new FileReader("./src/Database/dataSource/Druid/druid.properties"));
		// InputStream inputStream = new FileInputStream("./src/Database/dataSource/Druid/druid.properties");
		// properties.load(inputStream);
		// 4. 获取连接池对象
		DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
		// 5. 获取连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
}
