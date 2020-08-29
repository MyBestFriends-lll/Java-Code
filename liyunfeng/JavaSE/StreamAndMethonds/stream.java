package StreamAndMethonds;

import java.util.ArrayList;
import java.util.List;

/*
使用Stream 流的方式，遍历集合，对集合中的数据进行过滤
Stream 流是JDK1.8 之后出现的，关注的做什么，而不是怎么做
 */
public class stream {
	public static void main(String[] args) {
		// 创建一个List 集合，存储姓名
		List<String> list = new ArrayList<>();
		list.add("张无忌");
		list.add("周芷若");
		list.add("赵敏");
		list.add("张强");
		list.add("张三丰");

		// 张 开头的名字
		// 名字长度等于3
		// 遍历
		list.stream()
				.filter(name -> name.startsWith("张"))
				.filter(name -> name.length() == 3)
				.forEach(name -> System.out.println(name));
	}
}
