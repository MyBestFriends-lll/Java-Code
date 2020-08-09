package File;

import java.io.*;

/*
File 类中一些创建删除的方法
public boolean createNewFile() 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
public boolean delete() 删除由此File 表示的文件或目录
	可以删除文件/文件夹
	true 删除成功; false 文件夹中有内容，不会删除，构造方法中路径不存在
	delete 直接删除，不进入回收站
public boolean mkdir() 创建由此File 表示的目录
public boolean mkdirs() 创建由此File 表示的目录，包括任何必需但不存在的父目录
 */
public class FileCreateDeleteMethods {
	public static void main(String[] args) throws IOException {
		/*
			返回值：true 文件不存在则会创建文件 false 文件存在，不创建
			注意：只能创建文件，不能创建文件夹
				 创建文件的路径必须存在，否则会抛出异常
			public boolean createNewFile() throws IOException
			createNewFile 声明抛出了IOException，调用这个方法时必须处理这个异常，throws 或者 try...catch
		 */
		File file1 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/File/a.txt");
		boolean b1 = file1.createNewFile();
		System.out.println(b1);
		file1.delete();
		File file2 = new File("./src/File/a.txt"); // 相对路径，项目的根目录
		System.out.println(file2.createNewFile());
		file2.delete();

		/*
			返回值：true 文件夹不存在则会创建 false 文件夹存在，构造方法中给出的路径不存在，不创建
			注意：只能创建文件夹，不能创建文件
				 创建文件夹的路径不存在，调用mkdirs 方法也会创建
		 */
		File file3 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/File/");
		File file4 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/File/test");
		File file5 = new File("./src/File/Dir1/Dir2/Dir3");
		System.out.println(file3.mkdir()); // 已经存在
		System.out.println(file4.mkdir()); // 不存在
		file4.delete();
		System.out.println(file5.mkdirs()); // 不存在，要创建多级文件夹
		file5.delete();
	}
}
