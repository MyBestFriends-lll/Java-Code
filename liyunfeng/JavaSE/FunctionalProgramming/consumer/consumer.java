package FunctionalProgramming.consumer;

import java.util.function.Consumer;

/*
java.util.function.Consumer<T> 接口则正好与Supplier 接口相反
它不是生产一个数据，而是消费一个数据，其数据类型由泛型决定
Consumer 接口中包含抽象方法 void accept(T t) 意为消费一个指定泛型的数据。

Consumer 是一个消费型接口,泛型指定什么类型，就可以使用accept 方法消费什么类型的数据
具体使用销售销售需要自定义（输出，计算...）
 */
public class consumer {
	/*
		定义一个方法，方法的参数传递一个字符串的姓名，参数传递Consumer 接口，泛型使用String
		可以使用Consumer 接口消费字符串的姓名
	 */
	public static void method(String name, Consumer<String> con) {
		con.accept(name);
	}

	public static void main(String[] args) {
		// 调用method 方法，传递字符串姓名，另一个参数是Consumer 接口是一个函数式接口，所以可以传递Lambda 表达式
		method("Tome&Jerry", (String t) -> {
			// 对传递的字符串进行消费
			System.out.println(t);

			String ret = new StringBuffer(t).reverse().toString();
			System.out.println(ret);
		});
	}
}
