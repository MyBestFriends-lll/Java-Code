package IO.ObjectStream;

import java.io.*;

/*
java.io.ObjectInputStream extends InputStream
ObjectInputStream ：对象的 反序列化 流
作用：把对象以 流 的方式从文件中 读取 出来
构造方法：
	ObjectInputStream(InputStream in) 创建从指定InputStream 读取 的ObjectInputStream
	参数：
		InputStream in ：字节 输入 流
特有的成员方法：
	void readObject() 从ObjectInputStream 读取对象。
使用步骤：
	1. 创建ObjectInputStream 对象，构造方法中传递 字节 输入 流
	2. 使用ObjectInputStream 对象中的方法readObject 读取保存对象的文件
	3. 释放资源
	4. 使用读取出来的对象（打印）
readObject 方法声明抛出了 ClassNotFoundException (class文件找不到异常)
当不存在对象的Class 文件时抛出此异常
反序列化的前提：
	1. 类必须实现Serializable （必须有标记）
	2. 必须存在类对应的Class 文件
 */
public class objectInputStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 1. 创建ObjectInputStream 对象，构造方法中传递 字节 输入 流
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/IO/ObjectStream/person.txt"));
		// 2. 使用ObjectInputStream 对象中的方法readObject 读取保存对象的文件
		Object o = ois.readObject();
		// 3. 释放资源
		ois.close();
		// 4. 使用读取出来的对象（打印）
		System.out.println(o);
	}
}
