package Reflect.ClassMethods.getMethods;

import Reflect.Person;

import java.lang.reflect.Method;

public class getMethodsDemo {
	/*
		Class 对象功能：
        3. 获取成员方法们
            - Method[] getMethods()
            - Method getMethod(String name, Class<?>... parameterTypes)

            - Method[] getDeclaredMethods()
            - Method getDeclaredMethod(String name, Class<?>... parameterTypes)
	 */
	public static void main(String[] args) throws Exception {
		// 1. 获取Person 的Class 对象
		// 位于当前包下的Person 类
		Class personClass = Person.class;
		/*
			获取成员方法们
	            - Method[] getMethods()
	            - Method getMethod(String name, Class<?>... parameterTypes)

	            - Method[] getDeclaredMethods()
	            - Method getDeclaredMethod(String name, Class<?>... parameterTypes)
		 */
		// 获取指定名称的方法
		// 无参
		Method eat_method = personClass.getMethod("eat");
		Person p = new Person();
		// 执行方法
		eat_method.invoke(p);

		// 获取指定名称的方法
		// 有参
		Method eat_method1 = personClass.getMethod("eat");
		// 执行方法
		eat_method.invoke(p, "rice");
		System.out.println("----------------");

		// 获取所有public修饰的方法
		// 除了Person类的方法其中也包含Object类的方法
		Method[] methods = personClass.getMethods();
		for (Method method : methods) {
			System.out.println(method);
			// method也有
			// method.setAccessible(true);
		}

		// 获取类名
		String className = personClass.getName();
		System.out.println(className); // 全类名，完整，包名
	}
}
