package IO.BufferedStream.Output.WriterStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
java.io.BufferedWriter extends Writer
BufferedWriter ：字符 缓冲 输出 流
继承自父类共性的成员方法：
	void write(int c) 写入单个字符
	void write(char[] cbuf) 写入字符数组
	void write(char[] cbuf, int off, int len) 写入字符数组的某一部分
	void write(String str) 写入字符串
	void write(String str, int off, int len) 写入字符串的一部分
	void flush() 成为新该流的缓冲
	void close() 关闭此流，但要先刷新它
构造方法：
	BufferedWriter(Writer out) 创建一个使用默认大小输出缓冲区的缓冲字符输出流
	BufferedWriter(Writer out, int size) 创建一个使用给定大小输出缓冲区得新缓冲字符输出流
	参数：
		Writer out ：字符输出流
			可以传递FileWriter 缓冲流会给FileWriter 增加一个缓冲区，提高FileWriter 的写入效率
		int size ：指定缓冲流内部缓冲区得大小，不指定默认
特有的成员方法：void newLine() 写入一个行分隔符号。会根据不同的操作系统，获取不同的行分隔符。
使用步骤：
	1. 创建BufferedWriter 构造方法中传递 字符 输出流
	2. 调用BufferedWriter 中的方法write 把数据写入到内存缓冲区中
	3. 调用BufferedWriter 中的方法flush 把内存缓冲区的数据，刷新到文件中
	4. 释放资源
 */
public class bufferedWriter {
	public static void main(String[] args) throws IOException {
		// 1. 创建BufferedWriter 构造方法中传递 字符 输出流
		BufferedWriter bw = new BufferedWriter(new FileWriter("./src/IO/bb.txt"));
		// 2. 调用BufferedWriter 中的方法write 把数据写入到内存缓冲区中
		for (int i = 0; i < 3; i++) {
			bw.write("把数据写入缓冲区中");
			bw.newLine();
		}
		// 3. 调用BufferedWriter 中的方法flush 把内存缓冲区的数据，刷新到文件中
		bw.flush();
		// 4. 释放资源
		bw.close();
	}
}
