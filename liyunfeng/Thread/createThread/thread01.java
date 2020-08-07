package Thread.createThread;
/*
创建多线程程序的第一种方式：创建Thread 类的子类
java.lang.Thread 类：是描述线程的类，想要实现多线程，必须继承Thread 类
实现步骤：
	1. 创建一个Thread 类的子类
	2. 在Thread 类的子类中重写Thread 类中的run方法，设置线程任务（开启线程要做什么）
	3. 创建Thread 类的子类对象
	4. 调用Thread 类中的start 方法，开启新的线程，执行run 方法
		void start() 使该线程开始执行：Java 虚拟机调用该线程的run 方法
		结果是两个线程并发地运行;当前线程（main 线程）和另一个线程（创建的新线程，执行其run 方法）
		多次启动一个线程是非法的。特别是当线程已经结束执行后，不能重新启动
	Java 程序属于抢占式调度，哪个线程优先级高，哪个线程先执行，同一个优先级，随机选择一个执行
 */
public abstract class thread01 {
	public static void main(String[] args) {
		// 3. 创建Thread 类的子类对象
		MyThread01 mt = new MyThread01();

		// 4. 调用Thread 类中的start 方法，开启新的线程，执行run 方法
		mt.start();
		// 哪个线程优先级高，哪个线程先执行，同一个优先级，随机选择一个执行
		for (int i = 0; i < 20; i++) {
			System.out.println("main:" + i);
		}
	}
}
