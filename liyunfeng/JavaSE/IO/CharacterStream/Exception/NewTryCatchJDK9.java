package IO.CharacterStream.Exception;

import java.io.*;

/*
JDK9 的新特性
在try 的前面可以定义对象，在try的后边可以增加一个()，在括号中直接引入
try中的代码执行完毕，会自动把流对象释放，不用写finally
格式：
	A a = new A();
	B b = new B();
	// 要用分号间隔
	try(a; b) {
		...
	} catch(异常类变量 变量名) {
		...
	}
 */
public class NewTryCatchJDK9 {
	public static void main(String[] args) throws IOException {
		// 1. 创建一个字节 输入 流对象，构造方法中绑定要读取的数据源
		FileInputStream fis = new FileInputStream("c:\\1.jpg");

		// 2. 创建一个字节 输出 流对象，构造方法中绑定要写入的目的地
		FileOutputStream fos = new FileOutputStream("d:\\1.jpg");
		try (fis; fos) {
			// 3. 使用字节 输入 流对象中的方法read 读取文件
			// 一次读取一个字节，写入一个字节的方式
			int len = 0;
			while ((len = fis.read()) != -1) {
				// 4. 使用字节 输出 流对象中的方法write 把读取的字节写入到目的地的文件中
				fos.write(len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// fos.write(1); // 流已经关闭，抛出异常 IOException: Stream Closed
	}
}
