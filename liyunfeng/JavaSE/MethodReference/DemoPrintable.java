package MethodReference;

public class DemoPrintable {
	// 定义一个方法，参数传递Printable 接口，对字符串进行打印
	public static void printString(Printable p) {
		p.print("Hello World");
	}

	public static void main(String[] args) {
		// 调用printString 方法，方法的参数Printable 是一个函数式接口，所以可以传递Lambda
		printString((s) -> {
			System.out.println(s);
		});
		/*
			分析：
				Lambda 表达式的目的，打印教书传递的字符串
				把参数s，传递给了System.out 对象，调用out 对象 中的方法println 对字符串进行了输出
				注意：
					1. System.out 对象是已经存在的
					2. println 方法也是已经存在的
				所以我们可以使用方法引用来优化Lambda 表达式，
				可以使用System.out 对象直接引用（调用）println 方法
			双冒号 :: 为引用运算符，它所在的表达式称为方法引用。
			如果Lambda 要表达的函数方案已经存在某个方法实现中，那么可以通过双冒号来引用该方法作为Lambda 的替代者
		 */
		printString(System.out::println);
	}
}
