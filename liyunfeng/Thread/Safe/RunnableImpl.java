package Thread.Safe;
/*
实现卖票案例
 */
public class RunnableImpl implements Runnable {
	// 定义一个多个线程共享的票源
	private int ticket = 100;
	@Override
	public void run() {
		while (true) {
			// 使线程睡眠会提高出现安全问题的概率
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 先判断票是否存在
			if (ticket > 0) {
				// 票存在，卖票 ticket --
				System.out.println(Thread.currentThread().getName() + " -> 正在卖第 " + ticket + " 张票");
				ticket --;
			}
		}
	}
}
