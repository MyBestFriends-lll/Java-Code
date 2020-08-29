package FunctionalProgramming.consumer;

import java.util.function.Consumer;

/*
Consumer 接口的默认方法andThen
作用：需要两个Consumer 接口，可以把两个Consumer 接口组合到一起，再对数据进行消费（操作）
例如：
Consumer<String> con1;
Consumer<String> con2;
String s = "hello";
con1.accept(s);
连接两个Consumer 接口再进行操作，谁写在前面谁先操作
con1.andThen(con2).accept(s);
 */
public class andThen {
	// 定义一个方法，方法的参数传递一个字符串的姓名，和两个Consumer 接口，泛型使用String
	public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
		// con1.accept(s);
		// con2.accept(s);

		// 使用andThen 方法，把两个Consumer 接口连接到一起，再一起操作
		con1.andThen(con2).accept(s); // con1 连接con2 ，写在前面的先操作
		System.out.println("-------");
		con2.andThen(con1).accept(s);
		// con1.andThen(con2).andThen(con3).accept(s);
	}

	public static void main(String[] args) {
		// 调用method 方法，传递一个字符串，两个Lambda 表达式
		method("Hello",
				(t) -> {
					System.out.println(t.toUpperCase());
				},
				(t) -> {
					System.out.println(t.toLowerCase());
				});
	}
}
