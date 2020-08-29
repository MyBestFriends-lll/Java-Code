package IO.ReverseStream;

import java.io.*;

/*
输出（写入）转换流
java.io.OutputStreamWriter extends Writer
OutputStreamWriter ：是字符流 通向字节流 得桥梁：可使用指定的charset 将要写入流中得字符 编码成 字节（编码：把能的变成看不懂的）
继承自父类的共性方法：
	void write(int c) 写入单个字符
	void write(char[] cbuf) 写入字符数组
	void write(char[] cbuf, int off, int len) 写入字符数组的某一部分
	void write(String str) 写入字符串
	void write(String str, int off, int len) 写入字符串的一部分
	void flush() 成为新该流的缓冲
	void close() 关闭此流，但要先刷新它
构造方法：
	OutputStreamWriter(OutputStream out) 创建使用默认字符编码的 OutputStreamWriter
	OutputStreamWriter(OutputStream out, String charsetName) 创建使用指定字符集的 OutputStreamWriter
	参数：
		OutputStream out：字节输出流，可以用来写转换之后的字节到文件中
		String charsetName：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8, gbk/GBK 不指定默认UTF-8
使用步骤：
	1. 创建OutputStreamWriter 对象，构造方法中传递字节输出流和指定的编码表名称
	2. 使用OutputStreamWriter 对象中的方法write 把字符转换为字节存储到缓冲区中（编码）
	3. 使用OutputStreamWriter 对象中的方法flush 把内存缓冲区中赌字节刷新到文件中（使用字节流写字节的过程）
	4. 释放资源
 */
public class outPutStreamWriter {
	public static void main(String[] args) throws IOException {
		write_utf_8();
		write_gbk();
	}

	// 使用转换流OutputStreamWriter 写GBK 格式的文件
	private static void write_gbk() throws IOException {
		// 1. 创建OutputStreamWriter 对象，构造方法中传递字节输出流和指定的编码表名称
		// 不指定字符集默认 UTF-8
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/IO/bb.txt"), "utf-8");
		// 2. 使用OutputStreamWriter 对象中的方法write 把字符转换为字节存储到缓冲区中（编码）
		osw.write("使用UTF-8写入");
		// 3. 使用OutputStreamWriter 对象中的方法flush 把内存缓冲区中赌字节刷新到文件中（使用字节流写字节的过程）
		osw.flush();
		// 4. 释放资源
		osw.close();
	}

	// 使用转换流OutputStreamWriter 写UTF-8 格式的文件
	private static void write_utf_8() throws IOException {
		// 1. 创建OutputStreamWriter 对象，构造方法中传递字节输出流和指定的编码表名称
		// 不指定字符集默认 UTF-8
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/IO/bb.txt"), "utf-8");
		// 2. 使用OutputStreamWriter 对象中的方法write 把字符转换为字节存储到缓冲区中（编码）
		osw.write("使用UTF-8写入");
		// 3. 使用OutputStreamWriter 对象中的方法flush 把内存缓冲区中赌字节刷新到文件中（使用字节流写字节的过程）
		osw.flush();
		// 4. 释放资源
		osw.close();
	}
}
