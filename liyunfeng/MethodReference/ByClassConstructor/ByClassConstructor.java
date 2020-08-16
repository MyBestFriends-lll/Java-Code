package MethodReference.ByClassConstructor;
/*
类的构造器（构造方法）引用
 */
public class ByClassConstructor {
	// 定义一个方法，参数传递姓名和PersonBuilder 接口，方法中通过姓名创建Person 对象
	public static void printName(String name, PersonBuilder pb) {
		Person person = pb.buildPerson(name);
		System.out.println(person.getName());
	}

	public static void main(String[] args) {
		// 调用printName 方法，参数PersonBuilder 是一个函数式接口，可以传递Lambda
		printName("Tom", (String name) -> {
			return new Person(name);
		});

		/*
			使用方法引用优化Lambda 表达式
			构造方法new Person(String name) 已知
			创建对象已知 new
			就可以使用Person引用new 创建 对象
		 */
		printName("Jerry", Person::new); // 使用Person 类的带参构造方法，通过传递的姓名创建对象
	}
}
