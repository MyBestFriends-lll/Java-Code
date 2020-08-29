package Lambda.Exercise.E02;

import java.util.Arrays;

/*
Lambda 表达式有参数有返回值的练习
需求：
	使用数组存储多个Person 对象
	对数组中的Person 对象使用Arrays 的sort 方法通过年龄进行升序排序
 */
public class PersonArrays {
	public static void main(String[] args) {
		// 使用数组存储多个Person 对象
		Person[] arr = {
				new Person("Tom", 28),
				new Person("Jerry", 10),
				new Person("Miffy", 8)
		};
		// 对数组中的Person 对象使用Arrays 的sort 方法通过年龄进行升序（前面 - 后面）排序
		/*Arrays.sort(arr, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});*/

		// 使用Lambda 表达式简化匿名内部类
		/*Arrays.sort(arr, (o1, o2) -> {
			return o1.getAge() - o2.getAge();
		});*/
		Arrays.sort(arr, (Person o1, Person o2) -> {
			return o1.getAge() - o2.getAge();
		});

		for (Person p : arr) {
			System.out.println(p);
		}
	}
}
