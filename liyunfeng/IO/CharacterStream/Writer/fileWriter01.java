package IO.CharacterStream.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
java.io.Writer ：字符 输出 流，是所有字符输出流的最顶层的父类，是一个抽象类
共性的成员方法：
	void write(int c) 写入单个字符
	void write(char[] cbuf) 写入字符数组
	void write(char[] cbuf, int off, int len) 写入字符数组的某一部分
	void write(String str) 写入字符串
	void write(String str, int off, int len) 写入字符串的一部分
	void flush() 成为新该流的缓冲
	void close() 关闭此流，但要先刷新它

java.io.FileWriter extends OutputStreamReader extends Writer
FileWriter ：文件字符输出流
作用：把内存中的字符数据写入文件中
构造方法：
	FileWriter(File file) 根据给定的File 对象构造一个FileWriter 对象
	FileWriter(String fileName) 根据给定的文件名构造一个FileWriter 对象
	参数：写入数据的目的地
		File file：就是一个文件
		String fileName：文件的路径
	续写：
	FileWriter(File file, boolean oppend)
	FileWriter(String fileName, boolean oppend)
	根据给定的文件名以及提示是否附加写入数据的boolean 值来构造对象
	参数：boolean oppend ：续写开关 true：不会创建新文件，可以续写（追加） false：创建新文件，覆盖原文件

构造方法的作用：
	1. 会创建一个FileWriter 对象
	2. 会根据构造方法中传递的文件/文件的路径，创建文件
	3. 会把FileWriter 对象指向创建好的文件
字符输出流的使用步骤（重点）：
	1. 创建FileWriter 对象，构造方法中绑定写入数据的目的地
	2. 使用FileWriter 中的方法write 把数据写入到内存缓冲区中（字符转换为字节的过程）
	3. 使用FileWriter 中的方法flush 把内存缓冲区中的数据，刷新到文件中
	4. 释放资源（会先把内存中的数据刷新到文件中）
 */
public class fileWriter01 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("./src/IO/in.txt");
		// 注意：字<节> 输出流直接写入文件
		//      字<符> 输出流则先写入内存再写入文件
		fw.write(97);
		// 3. 使用FileWriter 中的方法flush 把内存缓冲区中的数据，刷新到文件中
		fw.flush();
		// 刷新之后流可以继续使用
		fw.write(98);
		// 4. 释放资源（会先把内存中的数据刷新到文件中）
		fw.close();
		// close 方法后流就已经关闭了，从内存中消失了，无法继续使用
		// fw.write(99); // IOException: Stream closed
	}
}
