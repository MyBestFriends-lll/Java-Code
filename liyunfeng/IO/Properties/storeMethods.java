package IO.Properties;

import java.io.*;
import java.util.Properties;

/*
可以使用Properties 集合中的方法store 把集合中的临时数据持久化写入到硬盘中
void store(OutputStream out, String comments)
void store(Writer writer, String comments)
参数：
	OutputStream ：字节输出流，不能写入中文
	Writer writer ：字符输出流，可以写入中文
	String comments ：注释，用来解释说明保存的文件是么用的，不能使用中文，会产生乱码默认是Unicode编码
		一般使用 "" 空字符串
使用步骤：
	1. 创建Properties 集合对象，添加数据
	2. 创建字节输出流/字符输出流对象，构造方法中绑定要输出得目的地
	3. 使用Properties 集合中的方法store 把集合中得临时数据持久化写入到硬盘中存储
	4. 释放资源
 */
public class storeMethods {
	public static void main(String[] args) throws IOException {
		// 1. 创建Properties 集合对象，添加数据
		// 创建Properties 集合对象
		Properties prop = new Properties();
		// 使用setProperties 往集合中添加数据
		prop.setProperty("Tom", "18岁");
		prop.setProperty("Jerry", "20岁");
		prop.setProperty("Miffy", "9岁");

		// 2. 创建字节输出流/字符输出流对象，构造方法中绑定要输出得目的地
		FileWriter fw = new FileWriter("./src/IO/in.txt");

		// 3. 使用Properties 集合中的方法store 把集合中得临时数据持久化写入到硬盘中存储
		prop.store(fw, "save data");
		// 4. 释放资源
		fw.close();
	}
}
