package File;

import java.io.File;

/*
path：路径
	绝对路径：是一个完整的路径
	相对路径：是一个简化的路径
	注意：1. 路径不区分大小写 2. windows用反斜杠表示所以是使用 \\
 */
public class FileConstructor {
	public static void main(String[] args) {
		// File 类的构造方法的使用
		// show01();
		// show02("C:", "a.txt");
		show03();
	}

	/*
		File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字字符串创建一个新 File 实例
		参数：把路径分成了两部分
			String parent 父路径
			String child 子路径
			参数可以变化，父路径是File 类型可以使用File 的方法进行一些操作，再使用路径创建对象
	 */
	private static void show03() {
		File parent = new File("/home/liyunfeng");
		File file = new File(parent, "bbbb.java");
		System.out.println(file);
	}

	/*
		File(String parent, String child) 根据 parent 路径名字字符串和 child 路径名字字符串创建一个新 File 实例
		参数：把路径分成了两部分
			String parent 父路径
			String child 子路径
			参数可以变化
	 */
	private static void show02(String parent, String child) {
		File file = new File(parent, child);
		System.out.println(file);
	}

	/*
		File(String pathname) 通过将给定路径名字字符串转换为抽象路径名来创建一个新 File 实例
		参数：
			String pathname 字符串的路径 名称
			路径可以是以文件结尾，也可以以文件夹
			路径可以是相对路径也可以是绝对路径
			路径可以存在，也可以不存在
			创建File 对象，只是吧字符串路径封装为File 对象，不考虑路径的真假情况
	 */
	private static void show01() {
		File f1 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/File/Path.java");
		System.out.println(f1); // 重写了toString 方法
		File f2 = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/File");
		System.out.println(f2);
		File f3 = new File("bb.java");
		System.out.println(f3);
	}
}
