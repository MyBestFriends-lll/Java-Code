package Thread.setName;

public class thread {
	public static void main(String[] args) {
		// 开启多线程
		MyThread mt = new MyThread();
		mt.setName("设置的线程名称");
		mt.start();

		// 开启多线程，带参数
		new MyThread("带参数的构造方法设置线程名称").start();
	}
}
