package MethodReference.ByThis;

public class Husband {
	// 定义一个买房子的方法
	public void buyHouse() {
		System.out.println("买了一套房子");
	}

	// 定义一个method 方法，参数传递Richable 接口
	public void method(Richable r) {
		r.buy();
	}

	// 定义一个使用方法
	public void use() {
		/*method(() -> {
			// 使用this.成员方法 的形式调用本类的buyHouse 方法
			this.buyHouse();
		});*/

		/*
			使用方法引用优化Lambda 表达式
			this 是已经存的
			本类的成员方法buyHouse 也已经存在
			所以可以直接使用this 引用本类的成员方法
		 */
		method(this::buyHouse);
	}

	public static void main(String[] args) {
		new Husband().use();
	}
}
