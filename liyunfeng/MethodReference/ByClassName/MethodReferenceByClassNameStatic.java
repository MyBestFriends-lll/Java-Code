package MethodReference.ByClassName;
/*
通过类名引用静态成员方法
类已经存在，静态成员方法也已经存在
就可以通过类名直接引用静态成员方法
 */
public class MethodReferenceByClassNameStatic {
	// 定义一个方法，方法的参数传递要计算绝对值的整数，和函数式接口Calculateable
	public static int method(int number, Calculateable c) {
		return c.calAbs(number);
	}

	public static void main(String[] args) {
		// 调用method 方法，传递计算绝对值的整数，和Lambda 表达式
		int number = method(-22, (n) -> {
			return Math.abs(n);
		});
		System.out.println(number);
		/*
			Math 类已经存在，静态成员方法abs 也已经存在
			就可以通过类名引用静态成员方法
		 */
		int number2 = method(-81, Math::abs);
		System.out.println(number2);
	}
}
