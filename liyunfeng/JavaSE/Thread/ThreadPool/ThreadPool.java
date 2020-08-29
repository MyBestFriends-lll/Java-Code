package Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
线程池：
	相当于一个容器 --> 即可以用集合存储（ArrayList, HashSet, </ LinkedList<Thread> />, HashMap）
	当程序第一次启动的时候，创建多个线程，保存到一个集合中
	当我们想要使用线程的时候，可以从集合中取出线程来用
	Thread t = list.remove(0); 返回的是被移除的元素（线程只能被一个任务使用）
	Thread t = linked.removeFirst(); 同上
	当使用完线程应该归还线程
	list.add(t);
	linked.addLast(t);
	JDK1.5 之后内置了线程池，可以直接创建
	java.util.concurrent.Executors: 线程池的工厂类，用来生成线程池
	Executors 类中的静态方法：
	static ExecutorService newFixedThreadPool(int nThreads) 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程
	参数：int nThreads 创建线程池中包含的线程数量
	返回值：ExecutorService 接口，返回的是ExecutorService 接口的实现类对象，我们可以使用ExecutorService 接口接收（面向接口编程）

	java.util.concurrent.ExecutorService：线程池接口
	用来从线程池中获取线程，调用start 方法执行线程任务
		Future<?> submit(Runnable task) 提交一个Runnable 任务用于执行，并返回一个表示改任务的Future
	关闭/销毁线程池的方法：void shutdown()
线程池的使用步骤：
	1. 使用线程池的工厂类Executors 提供的静态方法newFixedThreadPool 成产一个指定线程数量的线程池
	2. 创建一个类，实现Runnable 接口，重写run 方法设置线程任务
	3. 调用ExecutorService 中的方法submit 传递线程任务（实现类），开启线程，执行run 方法
	4. 调用ExecutorService 中的方法shutdown 销毁线程池（不建议执行）
 */
public class ThreadPool {
	public static void main(String[] args) {
		// 1. 使用线程池的工厂类Executors 提供的静态方法newFixedThreadPool 成产一个指定线程数量的线程池
		ExecutorService es = Executors.newFixedThreadPool(2);
		// 3. 调用ExecutorService 中的方法submit 传递线程任务（实现类），开启线程，执行run 方法
		RunnableImpl r = new RunnableImpl();
		es.submit(r);
		// 线程池会一直开启，使用完了线程会自动吧线程归还给线程池，线程可以继续使用
		es.submit(new RunnableImpl());
		es.submit(new RunnableImpl());
		// 4. 调用ExecutorService 中的方法shutdown 销毁线程池（不建议执行）
		// 程序会停止
		es.shutdown();
		// es.submit(new RunnableImpl()); // 抛出异常，线程池没有了，就不能在获取线程了
	}
}
