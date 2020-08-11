package IO;

import java.io.*;

/*
文件练习：一读一写
数据源：C:\\1.jpg
目的地：D:\\1.jpg
文件复制的步骤：
	1. 创建一个字节 输入 流对象，构造方法中绑定要读取的数据源
	2. 创建一个字节 输出 流对象，构造方法中绑定要写入的目的地
	3. 使用字节 输入 流对象中的方法read 读取文件
	4. 使用字节 输出 流对象中的方法write 把读取的字节写入到目的地的文件中
	5. 释放资源

	一次一个字节 耗时：16240毫秒
	一次1024字节 耗时：35毫秒
 */
public class CopyFile {
	public static void main(String[] args) throws IOException {
		long s = System.currentTimeMillis();
		// 1. 创建一个字节 输入 流对象，构造方法中绑定要读取的数据源
		// FileInputStream fis = new FileInputStream("c:\\1.jpg");
		FileInputStream fis = new FileInputStream("/home/liyunfeng/Videos/渡边美穗.mp4");
		// 2. 创建一个字节 输出 流对象，构造方法中绑定要写入的目的地
		// FileOutputStream fos = new FileOutputStream("d:\\1.jpg");
		FileOutputStream fos = new FileOutputStream("./src/IO/渡边美穗.mp4");
		// 3. 使用字节 输入 流对象中的方法read 读取文件
		// 一次读取一个字节，写入一个字节的方式
		/*int len = 0;
		while ((len = fis.read()) != -1) {
			// 4. 使用字节 输出 流对象中的方法write 把读取的字节写入到目的地的文件中
			fos.write(len);
		}*/

		// 使用数组缓冲一次读取多个字节
		byte[] bytes = new byte[1024];
		int len = 0;
		while ((len = fis.read(bytes)) != -1) {
			fos.write(bytes, 0, len);
		}

		// 5. 释放资源（先关闭写入（输出）的，后关闭读取的，写入（输出）完成了肯定读取完了）
		fos.close();
		fis.close();
		long e = System.currentTimeMillis();
		System.out.println("耗时：" + (e - s) + "毫秒");
	}
}
