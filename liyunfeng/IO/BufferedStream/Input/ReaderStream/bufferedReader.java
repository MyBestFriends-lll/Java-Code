package IO.BufferedStream.Input.ReaderStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
java.io.BufferedReader extends Reader
BufferedReader ：字符 缓冲 输入 流
继承自父类的方法：
	int read() 读取单个字符并返回
	int read(char[] cbuf) 一次读取多个字符，将字符读入数组
	void close() 关闭该流并释放与之关联的所有资源
构造方法：
	BufferedReader(Reader in) 创建一个使用默认大小输出缓冲区的缓冲字符输出流
	BufferedReader(Reader in, int size) 创建一个使用给定大小输出缓冲区得新缓冲字符输出流
	参数：
		Reader in ：字符 输入 流
			可以传递FileReader 缓冲流会给FileReader 增加一个缓冲区，提高FileReader 的写入效率
		int size ：指定缓冲流内部缓冲区得大小，不指定默认
特有的成员方法：String readLine() 读取一行文本行。读取一行数据
	终止符：读取一个文本行。通过下列字符之一即可认为某行已终止：换行（‘\n’）、回车（‘\r’）或回车后直接跟着换行（‘\r\n’）
	返回：包含该行内容的字符串，不包含任何终止符，如果已到达流末尾，则返回 null
使用步骤：
	1. 创建BufferedReader 对象，构造方法中传递字符输入流
	2. 使用BufferedReader 对象中的方法read/readLine 读取文本
	3. 释放资源
 */
public class bufferedReader {
	public static void main(String[] args) throws IOException {
		// 1. 创建BufferedReader 对象，构造方法中传递字符输入流
		BufferedReader br = new BufferedReader(new FileReader("./src/IO/bb.txt"));
		// 2. 使用BufferedReader 对象中的方法read/readLine 读取文本
		/*int len = 0;
		while ((len = br.read()) != -1) {
			System.out.println(len);
		}*/

		/*char[] chars = new char[1024];
		int len = 0; // 读取的有效字符数
		while ((len = br.read(chars)) != -1) {
			System.out.println(new String(chars, 0, len));
		}*/

		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
		// 3. 释放资源
		br.close();
	}
}
