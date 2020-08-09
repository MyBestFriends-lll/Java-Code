package File;

import java.io.File;

/*
File 类中一些判断的方法
public boolean exists() 此File 表示的文件或目录是否实际存在
// 路径必须存在，否则都返回false
public boolean isDirectory() 此File 表示的是否为目录
public boolean isFile() 此File 表示的是否为文件
 */
public class FileJudgmentMethods {
	public static void main(String[] args) {
		File file1 = new File("aa.txt"); // 相对路径，当前项目的根目录
		File file2 = new File("/home/liyunfeng/IdeaProjects/HelloWorld");
		System.out.println(file1.exists());
		System.out.println(file2.exists());

		File file3 = new File("/home/liyunfeng/IdeaProjects/HelloWorld");
		File file4 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/aa.txt");
		// 路径必须存在，否则都返回false
		// 判断构造方法是否以文件夹结尾
		System.out.println(file3.isDirectory());
		System.out.println(file4.isDirectory());

		File file5 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/File/MyFile.java");
		File file6 = new File("/home/liyunfeng/IdeaProjects/HelloWorld");
		// 路径必须存在，否则都返回false
		// 判断构造方法是否以文件结尾
		System.out.println(file5.isFile());
		System.out.println(file6.isFile());
	}
}
