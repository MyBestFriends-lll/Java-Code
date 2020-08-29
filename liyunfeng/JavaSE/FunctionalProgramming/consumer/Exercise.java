package FunctionalProgramming.consumer;

import java.util.function.Consumer;

/*
练习：
字符串数组当中存有多条信息，请按照格式“姓名：XX。性别：XX。”的格式将信息打印出来。
要求将打印姓名的动作做为定义个Consumer 接口的Lambda 实例，将打印性别的做为第二个，
将两个Consumer 接口按照商品顺序“拼接”到一起。
 */
public class Exercise {
	// 定义一个方法，参数传递String 类型的数组和两个Consumer 接口，泛型使用String
	public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
		for (String s : arr) {
			con1.andThen(con2).accept(s);
		}
	}
	public static void main(String[] args) {
		// 定义一个字符串类型的数组
		String[] arr = {"小明,男", "小红,女", "小林,男"};
		printInfo(arr,
				(message) -> {
					String[] split = message.split(",");
					System.out.print("姓名：" + split[0] + "  ");
				},
				(message) -> {
					String sex = message.split(",")[1];
					System.out.println("性别：" + sex);
				});
	}
}
