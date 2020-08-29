package IO.ObjectStream;

import java.io.*;

/*
java.io.ObjectOutputStream extends OutputStream
ObjectOutputStream ：对象的 序列化 流
作用：把对象以 流 的方式 写入 到文件中保存
构造方法：
	ObjectOutputStream(OutputStream out) 创建写入指定OutputStream 的ObjectOutputStream
	参数：
		OutputStream out ：字节 输出 流
特有的成员方法：
	void writeObject(Object obj) 将指定的对象写入ObjectOutputStream
使用步骤：
	1. 创建ObjectOutputStream 对象，构造方法中传递 字节 输出 流
	2. 使用ObjectOutputStream 对象中的方法writeObject 把对象写入到文件中
	3. 释放资源

static 关键字：静态关键字
	静态优先于非静态加载到内存中（静态优先于对象进入到内存中）
	被static 修饰的成员变量不能被序列化的，序列化得都是对象
transient 关键字：瞬态关键字
	被transient 修饰的成员变量，不能被序列化
 */
public class objectOutputStream {
	public static void main(String[] args) throws IOException {
		// 1. 创建ObjectOutputStream 对象，构造方法中传递 字节 输出 流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/IO/ObjectStream/person.txt"));
		// 2. 使用ObjectOutputStream 对象中的方法Object 把对象写入到文件中
		// java.io.NotSerializableException: IO.ObjectStream.Person
		// 当实例需要具有序列化接口时，抛出此异常。序列化运行时或实例的类会抛出此异常。参数应该为类的名称
		// NotSerializableException ：类通过实现java.io.Serializable 接口以启用其序列化的功能，未实现无法使其任何状态序列化或反序列化
		oos.writeObject(new Person("Tom", 20));
		oos.writeObject(new Person("小明", 16));
		// 以二进制写入的，读取会出错误
		// 3. 释放资源
		oos.close();
	}
}
