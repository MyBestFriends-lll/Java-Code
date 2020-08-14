package FunctionalProgramming.function;

import java.util.function.Function;

/*
Function 接口中的默认方法andThen ：用来进行组合操作
需求：把String 类型的“123” 转换为Integer 类型，把转换后的结果加10
把增加后的Integer 类型的数据，转换为String 类型
 */
public class andThen {
	public static void doubleChange(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
		// Integer ap1 = fun1.apply(s);
		// String ap2 = fun2.apply(ap1);
		String ap2 = fun1.andThen(fun2).apply(s);
		System.out.println(ap2);
	}

	public static void main(String[] args) {
		String s = "123";
		doubleChange(s,
				(String str) -> {
					return Integer.parseInt(str);
				},
				(Integer in) -> {
					in += 10;
					return in.toString();
				});
	}
}
