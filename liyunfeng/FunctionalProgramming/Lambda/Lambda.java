package FunctionalProgramming.Lambda;
/*
使用Lambda 优化日志案例
Lambda 的特点：延迟加载
Lambda 的使用前提，必须存在函数式接口
 */
public class Lambda {
	// 定义一个根据日志的级别，显示日志信息的方法，参数传递日志等级和MessageBuilder 接口
	public static void showLog(int level, MessageBuilder mb) {
		if (level == 1) {
			System.out.println(mb.builderMessage());
		}
	}

	public static void main(String[] args) {
		String msg1 = "Hello";
		String msg2 = "World";
		String msg3 = "Java";

		// 调用showLog 方法，参数MessageBuilder 是一个函数式接口，索引可以传递Lambda 表达式
		showLog(1, () -> {
			return msg1 + msg2 + msg3;
		});

		/*
			使用Lambda 表达式作为参数传递，仅仅是把参数传递到showLog 方法中
			只有满足条件，才会调用接口MessageBuilder 中的方法builderMessage，才会进行字符串的拼接
			条件不满足，接口MessageBuilder 中的方法builderMessage 不执行，所以不会浪费性能
		 */
		showLog(2, () -> {
			System.out.println("不满足时候不执行");
			return msg1 + msg2 + msg3;
		});
	}
}
