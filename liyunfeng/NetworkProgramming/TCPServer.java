package NetworkProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP 通信的服务器端：接收客户端的请求，读取客户端发送的数据，给客户端回写数据
表示服务器的类：
	java.net.ServerSocket ：此类实现服务器套接字。服务器套接字等待请求通过网络传入。它基于该请求执行某些操作，然后可能向请求者返回结果。
	服务器套接字的实际工作由SocketImpl 类的实例执行
构造方法：
	ServerSocket(int port) 创建绑定到特定端口的服务器套接字
服务端必须明确一件事：必须知道是哪个客户端请求的服务器，所以可以使用accept 方法获取到请求的客户端对象Socket
成员方法：
	Socket accept() 侦听并接受到此套接字的连接。
服务器的实现步骤：
	1. 创建服务器ServerSocket 对象和系统要指定的端口号
	2. 使用ServerSocket 对象中的方法accept 获取到请求的客户端对象Socket
	3. 使用Socket 对象中得方法getInputStream() 获取 网络字节 输入 流 对象
	4. 使用 网络字节 输入 流InputStream 对象中的方法read 读取客户端发送的数据
	5. 使用Socket 对象中的方法getOutputStream() 获取 网络字节 输出 流 对象
	6. 使用 网络字节 输出 流OutputStream 对象中的方法write 给客户端回写数据
	7. 释放资源（Socket , ServerSocket）
 */
public class TCPServer {
	public static void main(String[] args) throws IOException {
		// 1. 创建服务器ServerSocket 对象和系统要指定的端口号
		ServerSocket server = new ServerSocket(7788);
		// 2. 使用ServerSocket 对象中的方法accept 获取到请求的客户端对象Socket
		Socket socket = server.accept();
		// 3. 使用Socket 对象中得方法getInputStream() 获取 网络字节 输入 流 对象
		InputStream is = socket.getInputStream();
		// 4. 使用 网络字节 输入 流InputStream 对象中的方法read 读取客户端发送的数据
		byte[] bytes = new byte[1024];
		int len = is.read(bytes);
		System.out.println(new String(bytes, 0, len));
		// 5. 使用Socket 对象中的方法getOutputStream() 获取 网络字节 输出 流 对象
		OutputStream os = socket.getOutputStream();
		// 6. 使用 网络字节 输出 流OutputStream 对象中的方法write 给客户端回写数据
		os.write("服务器收到，返回数据".getBytes());
		// 7. 释放资源（Socket , ServerSocket）
		socket.close();
		server.close();
	}
}
