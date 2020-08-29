package MethodReference.BySuper;
/*
定义子类
 */
public class Man extends Human {
	// 重写父类sayHello 方法

	@Override
	public void sayHello() {
		System.out.println("Hello 我是Man");
	}

	// 定义一个方法，参数传递Greetable 接口
	public void method(Greetable g) {
		g.greet();
	}

	public void show() {
		// 调用method 方法，方法的参数Greetable 是一个函数式接口，所以可以传递Lambda
		/*method(() -> {
			// 创建父类，调用父类的方法
			Human h = new Human();
			h.sayHello();
		});*/

		// 因为有子父类关系，所以存在一个关键字super 代表父类，可以直接使用super 调用父类的成员方法
		/*method(() -> {
			super.sayHello();
		});*/

		/*
			Man 类和Human 类已经存在，父类和字累成员方法sayHello 也已经存在
			就可以通过类名引用成员方法
		 */
		method(super::sayHello);
	}

	public static void main(String[] args) {
		new Man().show();
	}
}
