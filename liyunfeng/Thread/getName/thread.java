package Thread.getName;
/*
获取线程的名称：
	1. 使用Thread 类中的方法getName()
		String getName() 返回该线程的名称
	2. 可以先获取当前正在执行的线程，使用线程中的方法getName() 获取线程的名称
		static Thread currentThread() 返回对当前正在执行的线程对象的引用
线程的名称：
	主线程：main
	新线程：Thread-0, Thread-1, Thread-2
 */
public abstract class thread {
	public static void main(String[] args) {
		// 3. 创建Thread 类的子类对象
		MyThread mt = new MyThread();
		// 4. 调用Thread 类中的start 方法，开启新的线程，执行run 方法
		mt.start();
		new MyThread().start();
		System.out.println(Thread.currentThread().getName());
	}
}
