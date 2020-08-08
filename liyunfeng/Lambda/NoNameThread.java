package Lambda;
/*
Lambda 表达式的标准格式：
	由三部分组成：
		1. 一些参数
		2. 一个箭头
		3. 一段代码
	格式：
		(参数列表) -> {重写方法的代码};
	说明：
		()：接口中抽象方法的参数列表，没有参数，就留空;有参数就写出参数，多个参数用逗号隔开
		->：传递的意思，把参数传递给方法体{}
		{}：重写接口的抽象方法的方法体
 */
public class NoNameThread {
	public static void main(String[] args) {
		// 使用匿名内部类的方式实现多线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -> 新线程创建了");
			}
		}).start();

		// 使用Lambda 表达式实现多线程
		new Thread( () -> {
			System.out.println(Thread.currentThread().getName() + " -> 新线程创建了");
		}).start();
	}
}
