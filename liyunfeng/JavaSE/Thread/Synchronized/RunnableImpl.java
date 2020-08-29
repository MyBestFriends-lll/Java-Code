package Thread.Synchronized;
/*
卖票案例出现了线程安全问题
卖出了不存在的票和重复的票

解决线程安全问题的一种方案：使用同步代码块
格式：
	synchronized(锁对象) {
		可能会出现线程安全问题的代码块（访问了共享数据的代码）
	}
注意：
	1. 同步代码块中的锁对象，可以使用任意的对象
	2. 但是必须保证多个线程使用的锁对象是同一个
	3. 锁对象的作用：把同步代码块锁住，只让一个线程在同步代码块中执行
 */
public class RunnableImpl implements Runnable {
	// 定义一个多个线程共享的票源
	private int ticket = 100;
	// 创建一个锁对象 需要保证唯一
	Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			// 同步代码块
			synchronized (obj) {
				// 先判断票是否存在
				if (ticket > 0) {
					// 使线程睡眠会提高出现安全问题的概率
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 票存在，卖票 ticket --
					System.out.println(Thread.currentThread().getName() + " -> 正在卖第 " + ticket + " 张票");
					ticket --;
				}
			}
		}
	}
}
