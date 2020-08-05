package Exception;

import java.io.*;

/*
throws 关键字：异常处理的第一种方式，交给别人处理
作用：
	当方法内部抛出异常对象的时候，那么我们就必须处理这个异常
	可以使用throws 关键字处理异常对象，会把异常对象声明抛出给方法的调用者处理（自己不处理，交给别人处理）最终交给JVM处理 -> 中断处理
使用格式：
	修饰符 返回值类型 方法名（参数列表） throws AAAException, BBBException ... {
		throw new AAAException("产生的原因");
		throw new BBBException("产生的原因");
		...
	}
注意事项：
	1. throws 关键字必须写在方法声明处
	2. throws 关键字后面声明的异常必须是Exception 或者是Exception 的子类
	3. 方法内部如果抛出了多个异常对象，那么throws 后面必须也声明多个异常
		如果抛出的多个异常对象有子父类关系，那么直接声明父类异常即可
	4. 调用了一个声明抛出异常的方法，我们就必须处理声明的异常
		要么继续使用throws 声明抛出，交给方法的调用者处理，最终给JVM
		要么使用try...catch 自己处理异常
 */
public class Throws {
	/*
		FileNotFoundException extends IOException
		IOException extends Exception
	 */
	// public static void main(String[] args) throws FileNotFoundException, IOException {
	// public static void main(String[] args) throws IOException {
	public static void main(String[] args) throws Exception {
		readFile("e:\\a.txt");
	}

	/*
		定义一个方法对传递的文件路径进行合法性判断
		如果路径不是"c:\\a.txt"那么就抛出文件找不到异常对象，告知方法的调用者
		注意：FileNotFoundException 是编译异常，抛出了异常就必须处理这个异常
		可以使用throws 继续声明抛出FileNotFoundException 这个异常对象，让方法的调用者处理
	 */
	private static void readFile(String fileName) throws IOException {
		if (!fileName.equals("c:\\a.txt")) {
			throw new FileNotFoundException("传递的文件路径不是c:\\a.txt");
		}

		/*
			如果传递的路径，不是 .txt 结尾那么抛出IO 异常对象，告知方法调用这，后缀名错误
		 */
		if (!fileName.endsWith(".txt")) {
			throw new IOException("文件的后缀名不对");
		}
		System.out.println("路径正确，读取文件");
	}
}
