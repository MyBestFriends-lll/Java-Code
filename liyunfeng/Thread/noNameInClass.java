package Thread;
/*
匿名内部类方式实现线程的创建
匿名：没有名字
内部类：写在其他类内部的类
匿名内部类的作用：简化代码
	把子类继承父类，重写父类方法，创建子类对象变成一步完成
	把实现类实现接口，重写接口中的方法，创建实现类对象变成一步完成
格式：
	new 父类/接口名字() {
		重写父类/接口方法
	};
 */
public class noNameInClass {
	public static void main(String[] args) {
		// 线程的父类是Thread
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName() + " -> " + i);
				}
			}
		}.start();

		// 线程的接口是Runnable
		// Runnable r = new RunnableImpl(); // 多态
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName() + " -> " + i + i);
				}
			}
		};
		new Thread(r).start();

		// 简化方式
		// new Thread(这里直接new一个接口).start();
	}
}
