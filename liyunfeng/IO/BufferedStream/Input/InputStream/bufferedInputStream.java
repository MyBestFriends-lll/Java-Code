package IO.BufferedStream.Input.InputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
java.io.BufferedInputStream extends InputStream
BufferedInputStream ：字节 缓冲 输入 流
继承自父类的方法：
	int read() 从输入流中读取数据的写一个字节
	int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b 中
	void close() 关闭此输入流并释放与此关联的任何系统资源
构造方法：
	BufferedInputStream(InputStream in) 创建一个BufferedInputStream 并保存其参数，及输入流 in 以便将来使用
	BufferedInputStream(InputStream in, int size) 创建一个具有指定缓冲区大小的BufferedInputStream 并保存其教书，即输入流in 以便将来使用
	参数：
		InputStream ：字节输入流
			可以传递FileInputStream 缓冲流会给FileInputStream 增加一个缓冲区，提高FileInputStream 的读取效率
		int size ：指定缓冲流内部缓冲区得大小，不指定默认
使用步骤：
	1. 创建FileInputStream 对象，构造方法中绑定要读取的数据源
	2. 创建BufferedInputStream 对象，构造方法中传递FileInputStream 对象，提高FileInputStream 对象得读取效率
	3. 使用BufferedInputStream 对象中的方法read 读取文件
	4. 释放资源
 */
public class bufferedInputStream {
	public static void main(String[] args) throws IOException {
		// 1. 创建FileInputStream 对象，构造方法中绑定要读取的数据源
		FileInputStream fis = new FileInputStream("./src/IO/bb.txt");
		// 2. 创建BufferedInputStream 对象，构造方法中传递FileInputStream 对象，提高FileInputStream 对象得读取效率
		BufferedInputStream bis = new BufferedInputStream(fis);
		// 3. 使用BufferedInputStream 对象中的方法read 读取文件
		/*int len = 0;
		while ((len = bis.read()) != -1) {
			System.out.println((char) len);
		}*/

		byte[] bytes = new byte[1024]; // 存储每次读取的数据
		int len = 0; // 存储每次 读取得有效字节个数
		while ((len = bis.read(bytes)) != -1) {
			System.out.println(new String(bytes, 0, len));
		}

		// 4. 释放资源
		bis.close();
		// 关闭缓冲流会自动把字节流关闭
		// fis.close();
	}
}
