package Thread.createThread;
// 1. 创建一个Thread 类的子类
public class MyThread01 extends Thread {
	// 2. 在Thread 类的子类中重写Thread 类中的run方法，设置线程任务（开启线程要做什么）
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("run:" + i);
		}
	}
}
