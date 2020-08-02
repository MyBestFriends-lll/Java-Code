package Map;

import java.util.*;

/*
HashMap 存储自定义类型key - value
Map 集合保证key 是唯一的：做为key 元素，必须重写hashCode / equals 方法，以保证key 唯一
 */
public class hashMapPerson {
	public static void main(String[] args) {
		Str_Per();
		System.out.println("------------------------");
		Per_Str();
	}

	/*
		key：Person 类型，Person 必须重写hashCode / equals 方法，以保证key 唯一
		value：String 类型，value 可以重复
	 */
	private static void Per_Str() {
		// 创建HashMap 集合
		HashMap<Person, String> map = new HashMap<>();
		// 添加元素
		// 存在重复的key
		map.put(new Person("张三", 18), "北京");
		map.put(new Person("李四", 19), "深圳");
		map.put(new Person("王五", 20), "广州");
		map.put(new Person("张三", 18), "上海");

		// System.out.println(map);
		// 遍历
		for (Map.Entry<Person, String> entry : map.entrySet()) {
			System.out.println((entry.getKey() + " -> " + entry.getValue()));
		}
	}

	/*
		key：String 类型，String 类型重写了hashCode / equals 方法，可以保证key 唯一
		value：Person 类型，value 可以重复（同名同年龄的人视为同一个）
	 */
	private static void Str_Per() {
		// 创建HashMap 集合
		HashMap<String, Person> map = new HashMap<>();
		// 添加元素
		// 存在重复的key
		map.put("北京", new Person("张三", 18));
		map.put("深圳", new Person("李四", 19));
		map.put("广州", new Person("王五", 20));
		map.put("北京", new Person("赵六", 18));

		// System.out.println(map);
		// 遍历
		for (String s : map.keySet()) {
			System.out.println(s + " -> " + map.get(s));
		}
	}
}
