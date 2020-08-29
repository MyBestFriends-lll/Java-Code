package IO.ReverseStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
输入（读取）转换流
java.io.inputStreamReader extends Reader
InputStreamReader :是字节流 通向字符流 的桥梁：它使用指定的charset 读取字节 并将其解码 为字符（解码：把看不懂的变成能看懂的）
共性的方法：
	int read() 读取单个字符并返回
	int read(char[] cbuf) 一次读取多个字符，将字符读入数组
	void close() 关闭该流并释放与之关联的所有资源
构造方法：
	InputStreamWriter(InputStream in) 创建使用默认字符编码的 InputStreamWriter
	InputStreamWriter(InputStream in, String charsetName) 创建使用指定字符集的 InputStreamWriter
	参数：
		InputStream in：字节输入 流，可以用来读取文件中保存的字节
		String charsetName：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8, gbk/GBK 不指定默认UTF-8
使用步骤：
	1. 创建InputStreamWriter 对象，构造方法中传递 字节 输入 流和指定的编码表名称
	2. 使用InputStreamWriter 对象中的方法read 读取文件
	3. 释放资源
注意事项：构造方法中指定的编码表名称要和文件的编码相同，否则会发生乱码
 */
public class inputStreamReader {
	public static void main(String[] args) throws IOException {
		read_utf_8();
		read_gbk();
	}

	// 使用InputStreamReader 读取GBK 格式的文件
	private static void read_gbk() throws IOException {
		// 1. 创建InputStreamWriter 对象，构造方法中传递 字节 输入 流和指定的编码表名称
		// 不指定字符集默认 UTF-8
		// UTF-8 是无法读取GBK 文件的
		InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/IO/bb.txt"), "GBK");
		// 2. 使用InputStreamWriter 对象中的方法read 读取文件
		int len = 0;
		while ((len = isr.read()) != -1) {
			System.out.println((char) len);
		}
		// 3. 释放资源
		isr.close();
	}

	// 使用InputStreamReader 读取UTF-8 格式的文件
	private static void read_utf_8() throws IOException {
		// 1. 创建InputStreamWriter 对象，构造方法中传递 字节 输入 流和指定的编码表名称
		// 不指定字符集默认 UTF-8
		InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/IO/bb.txt"));
		// 2. 使用InputStreamWriter 对象中的方法read 读取文件
		int len = 0;
		while ((len = isr.read()) != -1) {
			System.out.println((char) len);
		}
		// 3. 释放资源
		isr.close();
	}
}
