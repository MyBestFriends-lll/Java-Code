package IO.CharacterStream.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
构造方法：
续写：
	FileWriter(File file, boolean oppend)
	FileWriter(String fileName, boolean oppend)
	根据给定的文件名以及提示是否附加写入数据的boolean 值来构造对象
	参数：boolean oppend ：续写开关 true：不会创建新文件，可以续写（追加） false：创建新文件，覆盖原文件
字符输出流的其他方法：
	void write(char[] cbuf) 写入字符数组
	void write(char[] cbuf, int off, int len) 写入字符数组的某一部分
	void write(String str) 写入字符串
	void write(String str, int off, int len) 写入字符串的一部分
 */
public class fileWriter02 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("./src/IO/in.txt");
		// void write(char[] cbuf) 写入字符数组
		char[] chars = {'a', 'b', 'c', '\n'};
		fw.write(chars);
		// abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分
		fw.write(chars, 2, 2);
		// void write(String str) 写入字符串
		String str = "Java\n";
		fw.write(str);
		// void write(String str, int off, int len) 写入字符串的一部分
		fw.write(str, 2, 3);

		fw.flush();
		fw.close();
	}
}
