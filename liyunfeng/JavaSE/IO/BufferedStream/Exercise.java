package IO.BufferedStream;

import java.io.*;
import java.util.HashMap;

/*
练习：
	对文本的内容进行，按照1, 2, 3, 4...的顺序
分析：
	1. 创建一个HashMap 集合对象 key：存储每行文本的序号（1, 2, 3）; value：存储每行得文本
	2. 创建BufferedReader 对象，构造方法中绑定 字符 输入 流
	3. 创建BufferedWriter 对象，构造方法中绑定 字符 输出 流
	4. 使用BufferedReader （输入）对象的方法readLine 逐行读取文本
	5. 对读取得文本进行切割，获取序号和文本内容
	6. 把切割好的存入HashMap 集合中（key 序号是有序的，会自动排序）
	7. 遍历HashMap 集合，获取每一个Key Value 键值对
	8. 把每一个键值对拼接成一个文本行
	9. 把拼接好的文本，使用BufferedReader 中的方法write ，然后写入文件
	10. 释放资源
 */
public class Exercise {
	public static void main(String[] args) throws IOException {
		// 1. 创建一个HashMap 集合对象 key：存储每行文本的序号（1, 2, 3）; value：存储每行得文本
		HashMap<String, String> map = new HashMap<>();
		// 2. 创建BufferedReader 对象，构造方法中绑定 字符 输入 流
		BufferedReader br = new BufferedReader(new FileReader("./src/IO/in.txt"));
		// 3. 创建BufferedWriter 对象，构造方法中绑定 字符 输出 流
		BufferedWriter bw = new BufferedWriter(new FileWriter("./src/IO/out.txt"));
		// 4. 使用BufferedReader （输入）对象的方法readLine 逐行读取文本
		String line = null;
		while ((line = br.readLine()) != null) {
			// 5. 对读取得文本进行切割，获取序号和文本内容
			String[] arr = line.split("\\.");
			// 6. 把切割好的存入HashMap 集合中（key 序号是有序的，会自动排序）
			map.put(arr[0], arr[1]);
		}
		// 7. 遍历HashMap 集合，获取每一个Key Value 键值对
		for (String key : map.keySet()) {
			String value = map.get(key);
			// 8. 把每一个键值对拼接成一个文本行
			line = key + "." + value;
			// 9. 把拼接好的文本，使用BufferedReader 中的方法write ，然后写入文件
			bw.write(line);
			bw.newLine();
		}
		// 10. 释放资源
		bw.close();
		br.close();
	}
}
