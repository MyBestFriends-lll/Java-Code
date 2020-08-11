package IO.BufferedStream.Output.OutputStream;

import java.io.*;

/*
java.io.BufferedOutputStream extends OutputStream
BufferedOutputStream ：字节 缓冲 输出 流
继承自父类的共性成员方法：
	public void close() 关闭此输出流并释放与此关联的任何系统资源
	public void flush() 刷新此输出流并强制任何缓冲的输出字节流被写出
	public void write(byte[] b) 将b.length 字节从指定的字节数组写入此输出流
	public void write(byte[] b, int off, int len) 从指定的字节数组写入len 字节，从偏移量off 开始输出到此输出流
	public abstract void write(int b) 将指定的字节输出流
构造方法：
	BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，以写入指定的底层输出流
	BufferedOutputStream(OutputStream out, int size) 创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流
	参数：
		OutputStream out ：字节输出流
			可以传递FileOutputStream 缓冲流会给FileOutputStream 增加一个缓冲区，提高FileOutputStream 的写入效率
		int size ：指定缓冲流内部缓冲区得大小，不指定默认
使用步骤：
	1. 创建FileOutputStream 对象，构造方法中绑定要输出得目的地
	2. 创建BufferedOutputStream 对象，构造方法中传递FileOutputStream 对象
	3. 使用BufferedOutputStream 对象中的方法write 把数据写入到内部缓冲区中
	4. 使用BufferedOutputStream 对象中的方法flush 把内部缓冲区中的数据刷新到文件中
	5. 释放资源（会先调用flush 方法刷新数据）
 */
public class bufferedOutputStream {
	public static void main(String[] args) throws IOException {
		// 1. 创建FileOutputStream 对象，构造方法中绑定要输出得目的地
		FileOutputStream fos = new FileOutputStream("./src/IO/bb.txt");
		// 2. 创建BufferedOutputStream 对象，构造方法中传递FileOutputStream 对象
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// 3. 使用BufferedOutputStream 对象中的方法write 把数据写入到内部缓冲区中
		bos.write("把数据写入内部缓冲区中".getBytes());
		// 4. 使用BufferedOutputStream 对象中的方法flush 把内部缓冲区中的数据刷新到文件中
		bos.flush();
		// 5. 释放资源（会先调用flush 方法刷新数据）
		bos.close();
		// 关闭缓冲流会自动把字节流关闭
		// fos.close();
	}
}
