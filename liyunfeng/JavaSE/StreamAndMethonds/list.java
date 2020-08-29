package StreamAndMethonds;

import java.util.*;

/*
使用传统的方式，遍历集合，对集合中的数据进行过滤
 */
public class list {
	public static void main(String[] args) {
		// 创建一个List 集合，存储姓名
		List<String> list = new ArrayList<>();
		list.add("张无忌");
		list.add("周芷若");
		list.add("赵敏");
		list.add("张强");
		list.add("张三丰");

		// 张 开头的名字
		List<String> Zhang = new ArrayList<>();
		for (String s : list) {
			if (s.startsWith("张")) {
				Zhang.add(s);
			}
		}

		// 名字长度等于3
		List<String> result = new ArrayList<>();
		for (String s : Zhang) {
			if (s.length() == 3) {
				result.add(s);
			}
		}
		// 遍历
		for (String s : result) {
			System.out.println(s);
		}
	}
}
