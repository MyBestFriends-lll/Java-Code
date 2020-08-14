package FunctionalProgramming.function;

import java.util.function.Function;

/*
练习：自定义函数模型拼接
请使用Function 进行函数模型的拼接，按照顺序执行的多个函数的操作为：
1. 将字符串截取数字年龄部分，得到字符串
	Function<String, String>
2. 将上一步的字符串转换成为int 类型的数字
	Function<String, Integer>
3. 将上一步的int 数字累加100 得到结果int 数字
	Function<Integer, Integer>
 */
public class Exercise {
	public static void change(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
		Integer result = fun1.andThen(fun2).andThen(fun3).apply(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		String s = "Tom,20";
		change(s,
				(String str) -> {
					return str.split(",")[1];
				},
				(String str) -> {
					return Integer.parseInt(str);
				},
				(Integer in) -> {
					return in += 100;
				});
	}
}
