package IO.ByteStream.InputStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
java.io.InputStream 字节 输入 流
此抽象类是表示字节输入流的所有类的超类
定义了所有子类共性的方法
int read() 从输入流中读取数据的写一个字节
int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b 中
void close() 关闭此输入流并释放与此关联的任何系统资源

java.io.FileInputStream extends InputStream
FileInputStream 文件字节输入流，作用：把硬盘文件中的数据，读取到内存中使用
构造方法：
	FileInputStream(File file) 通过打开一个到实际文件的连接来创建一个FileInputStream，该文件通过文件系统中的File 对象file 指定
	FileInputStream(String name) 通过打开一个到实际文件的连接来创建一个FileInputStream，该文件通过文件系统中的路径名name 指定
	参数：
		File file：文件
		String name：文件的路径
	构造方法的作用：
		1. 会创建一个FileInputStream 对象
		2. 会把FileInputStream 对象指向构造方法中指定读取的文件
 */
public class inputStream {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/IO/bb.txt");
		int r = fis.read(); // 读取一个字节，然后移动到下一个字节
		System.out.println(r);

		byte[] b = new byte[13];
		fis.read(b); // 读取一定数量的字节，取决于byte 数组的大小
		for (byte b1 : b) {
			System.out.println(b1);
		}

		System.out.println(fis.read()); // 读取到文件末尾返回 -1
		System.out.println("--------------");
		// 使用循环读取 到文件末尾 -1时结束
		/*int r;
		while ((r = fis.read()) != -1) {
			System.out.println(r);
		}*/

		/*byte[] bytes = fis.readAllBytes();
		for (byte aByte : bytes) {
			System.out.println(aByte);
		}*/
		fis.close();
	}
}
