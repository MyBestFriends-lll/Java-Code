package FunctionalProgramming.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
练习：集合信息筛选
数组当中有多条“姓名 + 性别”的信息，请通过Predicate 接口的拼装将符合要求的字符串筛选到集合ArrayList 中
1. 必须为女生 2. 姓名必须为4个字
分析：
	1, 需要使用2个Predicate 接口，对条件进行判断
	2. 必须同时满足两个条件，所以可以使用and 方法连接两个条件
 */
public class Exercise {
	/*
		定义一个方法，参数传递一个包含人员信息的数组
		传递两个Predicate 接口，用于对数组中的信息进行过滤
		满足条件的存入ArrayList 集合中并返回
	 */
	public static ArrayList<String> filter(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
		ArrayList<String> target = new ArrayList<>();

		for (String s : arr) {
			if (pre1.and(pre2).test(s)) {
				target.add(s);
			}
		}

		return target;
	}

	public static void main(String[] args) {
		String[] arr = {"Tom,男", "Miffy,女", "sakura,女"};
		ArrayList<String> result = filter(arr,
				(String s) -> {
					String[] split = s.split(",");
					return split[0].length() > 4;
				},
				(String s) -> {
					String[] split = s.split(",");
					return split[1].equals("女");
				});
		System.out.println(result);
	}
}
