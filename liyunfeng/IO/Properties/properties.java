package IO.Properties;

import java.util.*;

/*
java.util.Properties 集合 extends Hashtable<K, V> implements Map<K, V>
Properties 类表示了一个持久得属性集 Properties 可保存在流中或从流中加载
Properties 集合是唯一一个和 IO 流 相结合的 集合
	可以使用Properties 集合中得方法store 把集合中得临时数据，持久化写入到硬盘存储
	可以使用Properties 集合中得方法load 把硬盘中保存的文件（键值对）读取到集合中使用
属性列表中每个键及其对应的值都是一个字符串
	Properties 集合是一个双列集合，key 和value 默认 都是字符串
 */
public class properties {
	public static void main(String[] args) {
		/*
			使用Properties 集合存储数据，遍历取出Properties 集合中的数据
			Properties 集合是一个双列集合，key 和value 默认都是字符串
			Properties 集合是有一些操作字符串的方法
			Object setProperty(String key, String value) 调用Hashtable 的方法put 添加元素
			String getProperty(String key) 通过key 找到value 值，此方法相当于Map集合中的get(key) 方法
			Set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串，此方法相当于Map 集合中的keySet 方法
		 */
		// 创建Properties 集合对象
		Properties prop = new Properties();
		// 使用setProperties 往集合中添加数据
		prop.setProperty("Tom", "18岁");
		prop.setProperty("Jerry", "20岁");
		prop.setProperty("Miffy", "9岁");
		// 不建议使用put 方法
		// prop.put(1, true);

		// 遍历取出元素
		Set<String> strings = prop.stringPropertyNames();
		for (String key : strings) {
			String value = prop.getProperty(key);
			System.out.println(key + " -> " + value);
		}
	}
}
