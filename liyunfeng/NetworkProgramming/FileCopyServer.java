package NetworkProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写“上传成功”
数据源：客户端上传的文件
目的地：服务器的硬盘 d:\\upload\\1.jpg
实现步骤：
	1. 创建一个服务器ServerSocket 对象，和系统要指定的端口号
	2. 使用ServerSocket 对象中的方法accept 获取到请求的客户端Socket 对象
	3. 使用Socket 中的方法getInputStream 获取 网络字节 输入 流InputStream 对象
	4. 判断d:\\upload 文件夹是否存在，不存在则创建
	5. 创建一个 本地字节 输入 流FileOutputStream 对象，构造方法中绑定要输出的目的地
	6. 使用 网络字节 输入 流InputStream 对象中得方法read 读取客户端上传的文件
	7. 使用 本地字节 输入 流FileOutputStream 对象中的方法write 把读取到的文件保存到服务器的硬盘上
	8. 使用Socket 中的方法getOutputStream 获取网络字节输出流OutputStream 对象
	9. 使用 网络字节 输出 流OutputStream 对象中的方法write 给客户端回写“上传成功”
	10. 释放资源（FileOutputStream, Socket， Server）
 */
public class FileCopyServer {
	public static void main(String[] args) throws IOException {
		// 1. 创建一个服务器ServerSocket 对象，和系统要指定的端口号
		ServerSocket server = new ServerSocket(7788);
		// 2. 使用ServerSocket 对象中的方法accept 获取到请求的客户端Socket 对象
		Socket socket = server.accept();
		// 3. 使用Socket 中的方法getInputStream 获取 网络字节 输入 流InputStream 对象
		InputStream is = socket.getInputStream();
		// 4. 判断d:\\upload 文件夹是否存在，不存在则创建
		File file = new File("d:\\upload");
		/*判断文件是否存在 不存在返回false*/
		if (!file.exists()) {
			file.mkdirs();
		}
		// 5. 创建一个 本地字节 输入 流FileOutputStream 对象，构造方法中绑定要输出的目的地
		FileOutputStream fos = new FileOutputStream(file + "\\1.jpg");
		// 6. 使用 网络字节 输入 流InputStream 对象中得方法read 读取客户端上传的文件
		int len = 0;
		byte[] bytes = new byte[1024];
		while ((len = is.read(bytes)) != -1) {
			// 7. 使用 本地字节 输入 流FileOutputStream 对象中的方法write 把读取到的文件保存到服务器的硬盘上
			fos.write(bytes, 0, len);
		}
		// 8. 使用Socket 中的方法getOutputStream 获取 网络字节 输出 流OutputStream 对象
		OutputStream os = socket.getOutputStream();
		// 9. 使用 网络字节 输出 流OutputStream 对象中的方法write 给客户端回写“上传成功”
		os.write("上传成功".getBytes());
		// 10. 释放资源（FileOutputStream, Socket， Server）
		fos.close();
		socket.close();
		server.close();
	}
}
