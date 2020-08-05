package Exception;
/*
自定义异常类：
	java 提供的异常类有时候不够，需要自己定义一些异常类
格式：
	public class xxxException extends Exception || RuntimeException {
		添加一个空参数的构造方法
		添加一个带异常信息的构造方法
	}
注意：
	1. 自定义异常类一般都是以Exception 结尾，说明该类是一个异常类
	2. 自定义异常类必须继承Exception 或者RuntimeException
		继承Exception 那么自定义的异常类就是一个编译期异常，如果方法内部抛出了，就必须处理，用throws 或者try...catch
		继承RuntimeException 那么自定义的异常类是一个运行时异常，无需处理，交给虚拟机处理（中断处理）
 */
public class RegisterException extends Exception /*注：如果是RuntimeException 可以不用处理，交给JVM处理即可*/{
	// 添加一个空参数的构造方法
	public RegisterException() {
	}

	// 添加一个带异常信息的构造方法
	// 调用父类的带异常信息的构造方法，让父类来处理这个异常信息
	public RegisterException(String message) {
		super(message);
	}
}
