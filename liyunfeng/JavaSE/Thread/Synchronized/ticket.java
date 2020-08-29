package Thread.Synchronized;
/*
线程共享安全问题
模拟卖票
 */
public class ticket {
	public static void main(String[] args) {
		// 创建Runnable 接口的实现类对象
		RunnableImpl run = new RunnableImpl();
		// 创建Thread 类对象，构造方法中传递Runnable 接口的实现类对象
		Thread t0 = new Thread(run);
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		// 调用start 方法开启多线程
		// 执行以后会出现线程安全问题，重复的票和不存在的票
		t0.start();
		t1.start();
		t2.start();
	}
}
