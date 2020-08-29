package Thread.createThread;
/*
创建多线程的第二种方式：实现Runnable 接口
java.lang.Runnable
	Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为 run 的无参方法。
java.lang.Thread 类的构造方法
	Thread(Runnable target) 分配新的 Thread 对象
	Thread(Runnable target, String name) 分配新的 Thread 对象
实现步骤：
	1. 创建一个Runnable 接口的实现类
	2. 在实现类中重写Runnable 接口的run 方法，设置线程任务
	3. 创建一个Runnable 接口的实现类对象
	4. 创建Thread 类对象，构造方法中传递Runnable 接口的实现类对象
	5. 调用Thread 类中的start 方法，开启新的线程执行run 方法

实现Runnable 接口创建多线程的好处：
	1. 可以避免单继承的局限性。
		一个类只能继承一个类，类继承了Thread 类就不能继承其他类
		实现Runnable 接口，还可继承其他类，实现其他接口
	2. 增加程序的健壮性和扩展性，实现解藕操作，代码可以被多个线程共享，代码和线程独立。
		实现Runnable 接口的方式，把设置线程任务和开启新线程进行了分离（解耦）
		实现类中重写了run 方法：用来设置线程任务
		创建Thread 对象，调用start 方法：用来开启新线程
 */
public class runnable {
	public static void main(String[] args) {
		// 3. 创建一个Runnable 接口的实现类对象
		MyRunnable myrun = new MyRunnable();
		// 4. 创建Thread 类对象，构造方法中传递Runnable 接口的实现类对象
		Thread mt = new Thread(myrun);
		// 5. 调用Thread 类中的start 方法，开启新的线程执行run 方法
		mt.start();

		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + " -> " + i);
		}
	}
}
