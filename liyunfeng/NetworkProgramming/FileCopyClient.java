package NetworkProgramming;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据
数据源：c;\\1.jpg
目的地：服务器
实现步骤：
	1. 创建一个 本地字节 输入 流FileInputStream 对象，构造方法中绑定要读取的数据源
	2. 创建一个客户端Socket 对象，构造方法中绑定服务器的IP 地址和端口号
	3. 使用Socket 中的方法getOutputStream 获取 网络字节 输出 流OutputStream 对象
	4. 使用 本地字节 输入 流FileInputStream 对象中的方法read 读取本地文件
	5. 使用 网络字节 输出 流OutputStream 对象中的方法write 把读取到的文件上传到服务器
	6. 使用Socket 中的方法getInputStream 获取 网络字节 输入 流InputStream 对象
	7. 使用 网络字节 输入 流InputStream 对象中得方法read 读取服务器回写的数据
	8. 释放资源
 */
public class FileCopyClient {
	public static void main(String[] args) throws IOException {
		// 1. 创建一个本地字节输入流FileInputStream 对象，构造方法中绑定要读取的数据源
		FileInputStream fis = new FileInputStream("c:\\1.jpg");
		// 2. 创建一个客户端Socket 对象，构造方法中绑定服务器的IP 地址和端口号
		Socket socket = new Socket("127.0.0.1", 7788);
		// 3. 使用Socket 中的方法getOutputStream 获取网络字节输出流OutputStream 对象
		OutputStream os = socket.getOutputStream();
		// 4. 使用本地字节输入流FileInputStream 对象中的方法read 读取本地文件
		int len = 0;
		byte[] bytes = new byte[1024];
		while ((len = fis.read(bytes)) != -1) {
			// 5. 使用网络字节输出流OutputStream 对象中的方法write 把读取到的文件上传到服务器
			os.write(bytes, 0, len);
		}
		// 6. 使用Socket 中的方法getInputStream 获取网络字节输入流InputStream 对象
		InputStream is = socket.getInputStream();
		// 7. 使用网络字节输入流InputStream 对象中得方法read 读取服务器回写的数据
		while ((len = fis.read(bytes)) != -1) {
			System.out.println(new String(bytes, 0, len));
		}
		// 8. 释放资源
		fis.close();
		socket.close();
	}
}
