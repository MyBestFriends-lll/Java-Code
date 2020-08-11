package IO.BufferedStream;

import java.io.*;

/*
文件练习：一读一写
数据源：C:\\1.jpg
目的地：D:\\1.jpg
文件复制的步骤：
	1. 创建一个字节 缓冲输入 流对象，构造方法中传递字节 缓冲输入 流
	2. 创建一个字节 缓冲输出 流对象，构造方法中传递字节 缓冲输出 流
	3. 使用字节 缓冲输入 流对象中的方法read 读取文件
	4. 使用字节 缓冲输出 流对象中的方法write 把读取的字节写入到目的地的文件中
	5. 释放资源（会先把缓冲区中的数据刷新到文件中）

	一次默认个字节 耗时：108毫秒
	一次1024个字节 耗时：51毫秒
	一次1024 * 2个字节 耗时：30毫秒
 */
public class BufferedStreamCopyFile {
	public static void main(String[] args) throws IOException {
		long s = System.currentTimeMillis();

		// 1. 创建一个字节 缓冲输入 流对象，构造方法中传递字节 缓冲输入 流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/home/liyunfeng/Videos/渡边美穗.mp4"));
		// 2. 创建一个字节 缓冲输出 流对象，构造方法中传递字节 缓冲输出 流
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./src/IO/渡边.mp4"));
		// 3. 使用字节 缓冲输入 流对象中的方法read 读取文件
		/*int len = 0;
		while ((len = bis.read()) != -1) {
			bos.write(len);
		}*/

		// 使用数组缓冲多个字节，写入多个字节
		byte[] bytes = new byte[1024 * 2];
		int len = 0;
		while ((len = bis.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}
		// 4. 使用字节 缓冲输出 流对象中的方法write 把读取的字节写入到目的地的文件中
		// 5. 释放资源（会先把缓冲区中的数据刷新到文件中）
		bos.close();
		bis.close();

		long e = System.currentTimeMillis();
		System.out.println("耗时：" + (e - s) + "毫秒");
	}
}
