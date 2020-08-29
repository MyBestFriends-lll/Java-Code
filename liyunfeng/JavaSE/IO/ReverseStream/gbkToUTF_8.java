package IO.ReverseStream;

import java.io.*;

/*
练习：转换文件编码
	将GBK 编码的文本文件，转换为UTF-8 编码的文本文件
分析：
	1. 创建InputStreamReader 对象，构造方法中绑定字节 输入 流和指定的编码表名称GBK
	2. 创建OutputStreamWriter 对象，构造方法中绑定字节 输出 流和指定的编码表名称UTF-8
	3. 使用InputStreamReader 对象中的方法read 读取文件
	4. 使用OutputStreamWriter 对象中的方法write 把读取的数据（字节）写入到文件中
	5. 释放资源
 */
public class gbkToUTF_8 {
	public static void main(String[] args) throws IOException {
		// 1. 创建InputStreamReader 对象，构造方法中绑定字节 输入 流和指定的编码表名称GBK
		InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/IO/bb.txt"), "GBK");
		// 2. 创建OutputStreamWriter 对象，构造方法中绑定字节 输出 流和指定的编码表名称UTF-8
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/IO/bb.txt"), "UTF-8");
		// 3. 使用InputStreamReader 对象中的方法read 读取文件
		int len = 0;
		while ((len = isr.read()) != -1) {
			osw.write(len);
		}
		// 4. 使用OutputStreamWriter 对象中的方法write 把读取的数据（字节）写入到文件中
		osw.flush();
		// 5. 释放资源
		osw.close();
		isr.close();
	}
}
