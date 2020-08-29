package File;

import java.io.File;

/*
File 遍历（文件夹）目录功能
	public String[] list() 返回一个String 数组，表示改File 目录中的所有子文件或目录
	public File[] listFiles() 返回一个File 数组，表示该File 目录中的所有子文件或目录
注意：
	list 方法和listFiles 方法遍历的是构造方法中给出的目录
	如果构造方法中给出的目录不存在，则会抛出空指针异常
	如果构造方法中给出的路径不是目录，也会抛出空指针异常
 */
public class FileTraversal {
	public static void main(String[] args) {
		File file1 = new File("./"); // 相对路径，当前项目根目录
		// File file1 = new File("./HelloWorld.xml"); // 相对路径，传递的是一个文件，抛出异常
		// File file1 = new File("./aaaaaaaa"); // 相对路径，文件夹路径不存在，抛出异常
		for (String s : file1.list()) {
			System.out.println(s);
		}

		// File file2 = new File("./"); // 相对路径，当前项目根目录
		File file2 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/");
		for (File file : file2.listFiles()) {
			// 会把路径打印出来
			System.out.println(file);
		}
	}
}
