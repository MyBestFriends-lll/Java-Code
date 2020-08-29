package IO.ByteStream.OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
一次写入多个字节的方法：
	public void write(byte[] b) 将b.length 字节从指定的字节数组写入此输出流
	public void write(byte[] b, int off, int len) 从指定的字节数组写入len 字节，从偏移量off 开始输出到此输出流
 */
public class outputStream02 {
	public static void main(String[] args) throws IOException {
		// 1. 创建一个FileOutputStream 对象，构造方法中传递写入数据的目的地
		// FileOutputStream fos = new FileOutputStream("./src/IO/in.txt");
		FileOutputStream fos = new FileOutputStream(new File("./src/IO/bb.txt"));
		// 2. 调用FileOutputStream 对象中的方法write，把数据写入到文件中
		// byte[] 参数注意：第一个字节是正数查询ASCII 表，第一个字节是负数第二个字节是正数组成中文显示查询默认码表（GBK）（Windows 简体中文）
		byte[] bytes = {65, 66, 67, 68, 69}; // ABCDE
		// byte[] bytes = {-65, 66, -67, 68, 69}; // 緽紻E
		fos.write(bytes); // 会覆盖之前写入的

		// 把字符串转换为字节数组
		fos.write("你好".getBytes());

		fos.write(bytes, 2, 3);
		// 3. 释放资源（流使用会占用一定的系统资源，使用完以后要释放）
		fos.close();
	}
}
