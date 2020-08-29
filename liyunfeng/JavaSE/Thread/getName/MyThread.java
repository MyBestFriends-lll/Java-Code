package Thread.getName;
// 1. 创建一个Thread 类的子类
public class MyThread extends Thread {
	// 2. 在Thread 类的子类中重写Thread 类中的run方法，设置线程任务（开启线程要做什么）
	@Override
	public void run() {
		// 获取线程名称
		// String name = getName();
		// System.out.println(name);

		// Thread t = Thread.currentThread();
		// System.out.println(t);
		// String name = t.getName();
		// System.out.println(name);

		// 链式编程
		System.out.println(Thread.currentThread().getName());
	}
}
