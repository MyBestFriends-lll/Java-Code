package Exception;

import java.io.IOException;

/*
try...catch：异常处理的第二种方式，自己处理异常
格式：
	try {
		可能产生异常的代码
	} catch (定义一个异常的变量，用来接收try 中抛出的异常对象） {
		异常的处理逻辑，捕获到异常后怎么处理异常
		一般工作中会把异常的信息记录到一个日志中
	} catch (异常类名 变量名) {
		...
	}
	...
注意：
	1. try 中可能抛出多个异常对象，那么就可以使用多个catch 来处理这些异常对象
	2. 如果try 中产生了异常，就会执行catch 中的异常处理逻辑，执行完毕后继续执行try...catch 之后的代码
		如果try 中没有产生异常那么就不会执行catch 中的异常处理逻辑，执行完try 中的代码以后，继续执行try...catch 之后的代码
多个异常的注意事项：
	1. 多个异常分别处理
	2. 多个异常一次捕获，多次处理
	3. 多个异常一次捕获一次处理
 */
public class TryCatch {
	public static void main(String[] args) {
		try {
			// 可能产生异常的代码
			readFile("d:\\a.tx");
		} catch (IOException e) { // 一般try 中抛出什么异常对象catch 就定义什么异常变量，用来接收这个异常对象
			// 异常的处理逻辑，捕获到异常后怎么处理异常
			// System.out.println("catch - 传递的文件名后缀不是.txt");

			/*
				Throwable 类中定义了3个异常的处理方法
				String getMessage() 返回此 throwable 的简短描述
				String toString() 返回此 throwable 的详细消息字符串
				void printStackTrace() JVM打印异常对象默认用此方法，打印的异常信息最全面
			 */
			System.out.println(e.getMessage());
		}
		System.out.println("后续代码");
	}

	/*
		如果传递的路径，不是 .txt 结尾那么抛出IO 异常对象，告知方法调用这，后缀名错误
	*/
	private static void readFile(String fileName) throws IOException {

		if (!fileName.endsWith(".txt")) {
			throw new IOException("文件的后缀名不对");
		}
		System.out.println("路径正确，读取文件");
	}
}
