package IO.Properties;

import java.io.*;
import java.util.*;

/*
可以使用Properties 集合中得方法load 把硬盘中保存的文件（键值对）读取到集合中使用
void load(InputStream inStream) 从输入流中读取属性列表（键和元素对）
void load(Reader reader) 按简单得面向行得格式从输入字符流中读取属性列表（键和元素对）
参数：
	InputStream inStream ：字节输入流，不可以读取含有中文的键值对
	Reader reader ：字符输入流，可以读取含有中文的键值对
使用步骤：
	1. 创建Properties 集合对象
	2. 使用Properties 集合对象中的方法load 读取保存键值对的文件
注意：
	1. 存储键值对的文件中，键与值默认得连接符号可以使用=，空格（或者其他符号）
	2. 存储键值对的文件中，可以使用# 进行注释，被注释的键值对不会再被读取
	3. 存储键值对的文件中，键与值默认都是字符串，不用再加引号
 */
public class loadMethods {
	public static void main(String[] args) throws IOException {
		// 创建Properties 集合对象
		Properties prop = new Properties();
		FileReader fr = new FileReader("./src/IO/in.txt");
		// FileInputStream fr = new FileInputStream("./src/IO/in.txt"); // 乱码问题
		prop.load(fr);

		Set<String> set = prop.stringPropertyNames();
		for (String key : set) {
			String value = prop.getProperty(key);
			System.out.println(key + " -> " + value);
		}

		fr.close();
	}
}
