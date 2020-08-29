package Exception;

import java.io.IOException;

/*
finally 代码块
格式：
	try {
		可能产生异常的代码
	} catch (定义一个异常的变量，用来接收try 中抛出的异常对象） {
		异常的处理逻辑，捕获到异常后怎么处理异常
		一般工作中会把异常的信息记录到一个日志中
	} catch (异常类名 变量名) {
		...
	} finally {
		无论是否出现异常都会执行
	}
注意：
	1. finally 不能单独使用，必须和try 一起使用
	2. finally 一般用于资源释放（资源回收），无论程序是否出现异常，最后都要释放资源（IO/数据库）
	3. finally 中如果有return 语句则永远都是返回finally 中的结果（因为不管怎么样都会被执行）要避免这种情况
 */
public class Finally {
	public static void main(String[] args) {
		try {
			// 可能产生异常的代码
			readFile("d:\\a.tx");
		} catch (IOException e) { // 一般try 中抛出什么异常对象catch 就定义什么异常变量，用来接收这个异常对象
			// 异常的处理逻辑，捕获到异常后怎么处理异常
			e.printStackTrace();
		} finally {
			// 无论是否出现异常，都会执行
			System.out.println("资源释放");
		}
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
