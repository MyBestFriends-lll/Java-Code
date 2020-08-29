package Lambda.Exercise.E02;
/*
Lambda 表达式有参数有返回值的练习
需求：
	使用数组存储多个Person 对象
	对数组中的Person 对象使用Arrays 的sort 方法通过年龄进行升序排序
 */
public class Person {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
