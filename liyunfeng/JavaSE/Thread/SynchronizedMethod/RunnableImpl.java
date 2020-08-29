package Thread.SynchronizedMethod;
/*
卖票案例出现了线程安全问题
卖出了不存在的票和重复的票

解决线程安全问题的二种方案：使用同步方法
使用步骤：
	1. 把访问了共享数据的代码块抽取出来，放到一个方法中
格式：定义方法的格式
修饰符 synchronized 返回值类型 方法名(参数列表) {
	可能会出现线程安全问题的代码块（访问了共享数据的代码）
}
 */
public class RunnableImpl implements Runnable {
	// 定义一个多个线程共享的票源
	private static int ticket = 100;

	@Override
	public void run() {
		System.out.println("this: " + this);
		while (true) {
			payTicketStatic();
		}
	}

	/*
		静态的同步方法
		锁对象是谁？
		不能是this 因为this 是创建对象之后产生的，静态方法优先于对象
		静态方法的锁对象是本类的class 属性 --> class文件对象（反射）
	 */
	public static /*synchronized*/ void payTicketStatic() {
		// synchronized (this) { // 错误
		synchronized (RunnableImpl.class) {
			// 先判断票是否存在
			// 因为是static 方法所以变量也应该是static 静态访问静态
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

	/*
		定义一个同步方法，同步方法也会把方法内部的代码锁住，只让一个线程执行
		同步方法的锁对象是谁？ this
		就是实现类对象 new RunnableImpl() 也就是this
	 */
	public synchronized void payTicket() {
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
