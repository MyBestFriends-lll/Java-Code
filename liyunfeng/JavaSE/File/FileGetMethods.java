package File;

import java.io.File;

/*
File 类中一些获取信息的方法
public String getAbsolutePath(); 返回此File 的绝对路径名字符串
public String getPath(); 将此File 装换为路径名字符串
public String getName(); 返回由此File 表示的文件或目录的名称
public long Length(); 返回由此File 表示的文件的长度
 */
public class FileGetMethods {
	public static void main(String[] args) {
		GetAbsolutePath();
		GetPath();
		GetName();
		GetLength();
	}

	private static void GetLength() {
		// 获取的是构造方法指定的文件大小，以字节为单位
		// 文件夹没有大小不能获取到，不存在的文件返回0
		File file1 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/File/MyFile.java"); // 普通文件
		File file2 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/aa.java"); // 不存在的文件
		File file3 = new File("/home/liyunfeng/IdeaProjects/HelloWorld"); // 文件夹 Linux 上是4096 Byte ~= 4 KB
		System.out.println(file1.length());
		System.out.println(file2.length());
		System.out.println(file3.length());
	}

	private static void GetName() {
		// 获取的就是构造方法传递路径的结尾部分（文件/文件夹）
		File file1 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/aa.java");
		File file2 = new File("/home/liyunfeng/IdeaProjects/HelloWorld");
		System.out.println(file1.getName());
		System.out.println(file2.getName());
	}

	private static void GetPath() {
		// 获取构造方法中传递的路径
		// toString 就是调用这个方法
		// public String toString() {
		//     return getPath();
		// }
		File file = new File("/home/liyunfeng/IdeaProjects/HelloWorld/aa.java");
		String path = file.getPath();
		System.out.println(path);
	}

	private static void GetAbsolutePath() {
		// 获取构造方法中传递的路径，无论是绝对还是相对路径，都是返回绝对路径
		File file = new File("aa.java");
		File absoluteFile = file.getAbsoluteFile();
		System.out.println(absoluteFile); // /home/liyunfeng/IdeaProjects/HelloWorld/aa.java
	}
}
