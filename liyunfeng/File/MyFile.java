package File;

import java.io.File;

/*
java.io.File 类
文件和目录路径名的抽象表示形式。
java 把电脑中的文件和文件夹（目录）封装为了一个File 类，我问可以使用File 类对文件和文件夹进行操作
我们可以使用File 类的方法
	创建一个文件/文件夹
	删除一个文件/文件夹
	获取文件/文件夹
	判断文件/文件夹是否存在
	对文件夹进行遍历
	获取文件的大小
File 类是一个与系统无关的类，任何操作系统都可以使用这个类中的方法
Tips:
	file：文件
	directory：文件夹/目录
	path：路径
 */
public class MyFile {
	public static void main(String[] args) {
		/*
			static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串
			static Char pathSeparatorChar 与系统有关的路径分隔符
			static String separator 与系统有关的默认名称（文件名称分隔符）分隔符，为了方便，它被表示为一个字符串
			static Char separatorChar 与系统有关的默认名称分隔符
			Tips:
				不要把路径写死了
				C:\develop\a\a.txt -> Windows
				/develop/a/a.txt ->   Linux
				使用静态变量组织路径
				"C:" + File.separator + "develop" + File.separator + "a" + File.separator + "a.txt"
		 */
		String pathSeparator = File.pathSeparator;
		System.out.println(pathSeparator);

		String separator = File.separator;
		System.out.println(separator);
	}
}
