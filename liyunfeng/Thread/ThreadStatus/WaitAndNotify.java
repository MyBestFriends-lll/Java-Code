package Thread.ThreadStatus;
/*
等待唤醒案例：线程之间的通信
	创建一个顾客线程（消费者）：告知老板包子的种类和数量，调用wait 方法，放弃cpu 的执行进入WAITING（无限等待状态）
	创建一个老板线程（生产者）：花5秒做包子，做好以后调用notify 方法唤醒顾客线程吃包子
注意：
	顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个
	同步使用的对象必须保证唯一
	只有锁对象才能调用wait 和 notify 方法
Object 类中的方法：
	void wait() 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待
	void notify() 唤醒在此对象监视器上等待的单个线程。会继续执行wait 方法之后的代码

	void wait(long mills) 传递一个毫秒值，等待指定的时间自动唤醒，相当于sleep 方法
	void notifyAll() 唤醒所有等待的线程
 */
public class WaitAndNotify {
	public static void main(String[] args) {
		// 创建锁对象保证唯一
		Object obj = new Object();
		// 创建一个顾客线程（消费者）
		// 匿名内部类
		new Thread() {
			@Override
			public void run() {
				// 可以用死循环一直执行
				while (true) {
					// 保证等待和唤醒的线程只有一个能运行，需要使用同步技术
					synchronized (obj) {
						System.out.println("告知老板包子的种类和数量");
						// 调用wait 方法，放弃cpu 的执行进入WAITING（无限等待状态）
						// 因为run 没有抛异常所以也不能抛异常
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						// 唤醒之后的代码
						System.out.println("包子做好了可以吃了");
						System.out.println("--------------------");
					}
				}
			}
		}.start();

		// 创建一个老板线程（生产者）
		new Thread() {
			@Override
			public void run() {
				// 可以用死循环一直执行
				while (true) {
					// 花5秒做包子
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// // 保证等待和唤醒的线程只有一个能运行，需要使用同步技术
					synchronized (obj) {
						System.out.println("老板5秒做好了，告知顾客");
						// 做好包子后，调用notify 方法唤醒顾客线程
						obj.notify();
					}
				}
			}
		}.start();
	}
}
