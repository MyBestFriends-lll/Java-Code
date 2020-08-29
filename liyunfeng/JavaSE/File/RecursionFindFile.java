package File;

import java.io.File;

/*
文件搜索
	1. 目录搜索，无法判断多少级目录，所以使用递归遍历
	2. 遍历目录时获取子文件，通过文件名称，判断是否符合条件
递归打印多级目录
 */
public class RecursionFindFile {
	public static void main(String[] args) {
		File file = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/Lambda");
		findFile(file, ".java");
	}

	public static void findFile(File dir, String str) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				// System.out.println(f);
				findFile(f, str);
			}
		}
		if (dir.getName().toLowerCase().endsWith(str)) { // 以str 为后缀
		// if (dir.getName().toLowerCase().equals(str)) {
			System.out.println(dir);
		}
	}

	/*public static void findFile(File dir, String str) {
		// System.out.println(dir);
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				findFile(f, str);
			} else {
				// System.out.println(f);
				if (f.getName().equals(str)) {
					System.out.println(f);
				}
			}
		}
	}*/
}
