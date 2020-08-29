package IO.ObjectStream;

import java.io.*;

/*
序列化和反序列化的时候，会抛出NotSerializableException 没有序列化异常
java.io.NotSerializableException: IO.ObjectStream.Person
当实例需要具有序列化接口时，抛出此异常。序列化运行时或实例的类会抛出此异常。参数应该为类的名称
	NotSerializableException ：类通过实现java.io.Serializable 接口以启用其序列化的功能，未实现无法使其任何状态序列化或反序列化
Serializable 接口也叫标记型接口
	要进行序列化和反序列化得类必须实现Serializable 接口，就会给类添加一个标记，当进行序列化和反序列化的时候就会检测类上是否有这个标记
	没有就抛出异常
Serializable 接口里面什么都没有，就是一个标记作用
 */
public class Person implements Serializable {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
