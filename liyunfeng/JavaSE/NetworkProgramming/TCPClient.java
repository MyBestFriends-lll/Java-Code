package NetworkProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP 通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据
表示客户端的类：
	java.net.Socket ：此类实现客户端套接字（也可以叫“套接字”）。套接字是两台机器之间通信的端点。
	套接字：包含了IP 地址和端口号的网络单位
构造方法：
	Socket(String host, int port) 创建一个流 套接字 并将其连接到指定 主机 上的指定端口号
	参数：
		String host ：服务器主机的名称/服务器的IP 地址
		int port ：服务器的端口号
成员方法：
	OutputStream getOutputStream() 返回此套接字得输出流
	InputStream getInputStream() 返回此套接字的输入流
	void close() 关闭此套接字
实现步骤：
	1. 创建一个客户端对象Socket，构造方法中绑定服务器的IP 地址和端口号
	2. 使用Socket 对象中的方法getOutputStream() 获取 网络字节 输出 流 对象
	3. 使用 网络字节 输出 流OutputStream 对象中的方法write 给服务器发送数据
	4. 使用Socket 对象中得方法getInputStream() 获取 网络字节 输入 流 对象
	5. 使用 网络字节 输入 流InputStream 对象中的方法read 读取服务器回写的数据
	6. 释放资源（Socket）
注意事项：
	1. 客户端和服务器端进行交互，必须使用Socket 中提供的网络流，不能使用自己创建的流对象
	2. 当我们创建客户端对象Socket 的时候，客户端就会去请求服务器，经过3 次握手后建立连接通路
		这时候如果服务器没有启动就会抛出异常，如果服务器已经启动，那么就可以进行交互
		异常：java.net.ConnectException: 拒绝连接
 */
public class TCPClient {
	public static void main(String[] args) throws IOException {
		// 1. 创建一个客户端对象Socket，构造方法中绑定服务器的IP 地址和端口号
		Socket socket = new Socket("127.0.0.1", 7788);
		// 2. 使用Socket 对象中的方法getOutputStream() 获取 网络字节 输出 流 对象
		OutputStream os = socket.getOutputStream();
		// 3. 使用 网络字节 输出 流OutputStream 对象中的方法write 给服务器发送数据
		os.write("客户端向服务器发送数据".getBytes());
		// 4. 使用Socket 对象中得方法getInputStream() 获取 网络字节 输入 流 对象
		InputStream is = socket.getInputStream();
		// 5. 使用 网络字节 输入 流InputStream 对象中的方法read 读取服务器回写的数据
		byte[] bytes = new byte[1024];
		int len = is.read(bytes);
		System.out.println(new String(bytes, 0, len));
		// 6. 释放资源（Socket）
		socket.close();
	}
}
