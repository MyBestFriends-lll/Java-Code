package Recursive;

import java.io.File;

/*
递归打印多级目录
 */
public class RecursionPrintFile {
	public static void main(String[] args) {
		File file = new File("/home/liyunfeng/IdeaProjects/HelloWorld/src/Lambda");
		getAllFile(file);
	}

	public static void getAllFile(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				System.out.println(f);
				getAllFile(f);
			}
		}
	}

	/*public static void getAllFile(File dir) {
		System.out.println(dir);
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				getAllFile(f);
			} else {
				System.out.println(f);
			}
		}
	}*/
}
