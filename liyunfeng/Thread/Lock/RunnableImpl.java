package Thread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
卖票案例出现了线程安全问题
卖出了不存在的票和重复的票

解决线程安全问题的三种方案：使用Lock 锁
java.util.concurrent.Locks.Lock 接口
Lock 实现提供了比使用 synchronized 方法和语句可获得更广泛的锁定操作。
Lock 接口中的方法：
	void Lock() 获取锁
	void unLock() 释放锁
java.util.concurrent.Locks.ReentrantLock implements Lock 接口
使用步骤：
	1. 在成员位置创建一个ReentrantLock 对象
	2. 在可能出现安全问题的代码 前 调用Lock 接口的方法Lock 获取锁
	3. 在可能出现安全问题的代码 后 调用Lock 接口的方法unLock 释放锁

}
 */
public class RunnableImpl implements Runnable {
	// 定义一个多个线程共享的票源
	private static int ticket = 100;
	// 1. 在成员位置创建一个ReentrantLock 对象 多态
	// ReentrantLock l = new ReentrantLock();
	Lock l = new ReentrantLock();

	/*@Override
	public void run() {
		// System.out.println("this: " + this);
		while (true) {
			// 2. 在可能出现安全问题的代码 前 调用Lock 接口的方法Lock 获取锁
			l.lock();

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

			// 3. 在可能出现安全问题的代码 后 调用Lock 接口的方法unLock 释放锁
			l.unlock();
		}
	}*/

	@Override
	public void run() {
		// System.out.println("this: " + this);
		while (true) {
			// 2. 在可能出现安全问题的代码 前 调用Lock 接口的方法Lock 获取锁
			l.lock();

			// 先判断票是否存在
			if (ticket > 0) {
				// 使线程睡眠会提高出现安全问题的概率
				try {
					Thread.sleep(10);
					// 票存在，卖票 ticket --
					System.out.println(Thread.currentThread().getName() + " -> 正在卖第 " + ticket + " 张票");
					ticket --;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// 3. 在可能出现安全问题的代码 后 调用Lock 接口的方法unLock 释放锁
					l.unlock(); // 无论程序是否异常都会把锁释放
				}
			}
		}
	}
}
