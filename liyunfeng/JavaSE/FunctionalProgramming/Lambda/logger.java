package FunctionalProgramming.Lambda;
/*
日志案例
发现以下代码存在一些性能浪费的问题
调用showLog 方法，传递的第二个参数是一个拼接后的字符串，先把字符拼接好然后再调用showLog 方法
如果日志等级不是1级，不打印那么就存在浪费
 */
public class logger {
	// 定义一个根据日志的级别，显示日志信息的方法
	public static void showLog(int level, String message) {
		if (level == 1) {
			System.out.println(message);
		}
	}

	public static void main(String[] args) {
		String msg1 = "Hello";
		String msg2 = "World";
		String msg3 = "Java";

		showLog(1, msg1 + msg2 + msg3);
	}
}
