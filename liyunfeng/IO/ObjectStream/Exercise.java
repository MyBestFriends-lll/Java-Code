package IO.ObjectStream;

import java.io.*;
import java.util.ArrayList;

/*
练习：序列化一个集合
	当想要保存多个对象时候，可以把对象存储到一个集合中，对集合进行序列化和反序列化
分析：
	1. 定义一个存储Person 对象的ArrayList 集合
	2. 往集合中添加Person 对象
	3. 创建ObjectOutputStream 对象，构造方法中传递 字节 输出 流
	4. 使用ObjectOutputStream 对象中的方法writeObject 把 集合 写入到文件中
	5. 创建ObjectInputStream 对象，构造方法中传递 字节 输入 流
	6. 使用ObjectInputStream 对象中的方法readObject 读取保存 集合 的文件
	7. 把Object 类型转换为ArrayList 类型
	8. 遍历ArrayList 集合
	9. 释放资源
 */
public class Exercise {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 1. 定义一个存储Person 对象的ArrayList 集合
		ArrayList<Person> list = new ArrayList<>();
		// 2. 往集合中添加Person 对象
		list.add(new Person("小红", 10));
		list.add(new Person("Tom", 20));
		list.add(new Person("Jerry", 18));
		// 3. 创建ObjectOutputStream 对象，构造方法中传递 字节 输出 流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/IO/ObjectStream/person.txt"));
		// 4. 使用ObjectOutputStream 对象中的方法writeObject 把 集合 写入到文件中
		oos.writeObject(list);
		// 5. 创建ObjectInputStream 对象，构造方法中传递 字节 输入 流
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/IO/ObjectStream/person.txt"));
		// 6. 使用ObjectInputStream 对象中的方法readObject 读取保存 集合 的文件
		Object o = ois.readObject();
		// 7. 把Object 类型转换为ArrayList 类型
		ArrayList<Person> list2 = (ArrayList<Person>) o;
		// 8. 遍历ArrayList 集合
		for (Person p : list2) {
			System.out.println(p);
		}
		// 9. 释放资源
		ois.close();
		oos.close();
	}
}
