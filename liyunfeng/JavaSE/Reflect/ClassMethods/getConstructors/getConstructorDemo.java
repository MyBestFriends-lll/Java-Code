package Reflect.ClassMethods.getConstructors;

import Reflect.Person;

import java.lang.reflect.Constructor;

public class getConstructorDemo {
	/*
		Class 对象功能：
        2. 获取构造方法们
            - Constructor<?>[] getConstructors()
            - Constructor<T> getConstructor(Class<?>... parameterTypes)

            - Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
            - Constructor<?>[] getDeclaredConstructors()
	 */
	public static void main(String[] args) throws Exception {
		// 1. 获取Person 的Class 对象
		// 位于当前包下的Person 类
		Class personClass = Person.class;
		/*
			获取构造方法们
	            - Constructor<?>[] getConstructors()
	            - Constructor<T> getConstructor(Class<?>... parameterTypes)

	            - Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
	            - Constructor<?>[] getDeclaredConstructors()
		 */
		// 获取两个参数的构造器，传入两个指定参数类型
		Constructor constructor = personClass.getConstructor(String.class, int.class);
		System.out.println(constructor);
		// 创建对象
		// 实际参数要匹配
		Object person = constructor.newInstance("Tom", 20);
		System.out.println(person);
		System.out.println("----------------");
		// 使用空参构造
		Constructor constructor1 = personClass.getConstructor();
		System.out.println(constructor1);
		Object person1 = constructor1.newInstance();
		System.out.println(person1);
		// Class 类中的方法，直接返回一个空参构造的对象
		Object o = personClass.newInstance();
		System.out.println(o);
	}
}
