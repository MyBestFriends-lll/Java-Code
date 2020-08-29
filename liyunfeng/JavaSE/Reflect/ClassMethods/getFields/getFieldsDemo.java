package Reflect.ClassMethods.getFields;

import Reflect.Person;

import java.lang.reflect.Field;

public class getFieldsDemo {
	/*
		Class 对象功能：
        1. 获取成员变量们
            - Field[] getFields() 获取所有public修饰的成员变量的
            - Field getField(String name) 获取指定名称的public修饰的成员变量的

            - Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰符
            - Field getDeclaredField(String name)
	 */
	public static void main(String[] args) throws Exception {
		// 1. 获取Person 的Class 对象
		// 位于当前包下的Person 类
		Class personClass = Person.class;
		/*
			获取成员变量们
	            - Field[] getFields() 获取所有public修饰的成员变量的
	            - Field getField(String name) 获取指定名称的public修饰的成员变量的

	            - Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰符
	            - Field getDeclaredField(String name)
		 */
		Field[] fields = personClass.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("----------------");
		Field a = personClass.getField("a");
		// 获取成员变量a 的值
		Person p = new Person();
		Object value = a.get(p);
		System.out.println(value);
		// 设置a的值
		a.set(p, "Tom");
		System.out.println(p);
		System.out.println("----------------");
		Field[] declaredFields = personClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			System.out.println(declaredField);
		}
		// 获取成员变量d 的值
		Field d = personClass.getDeclaredField("d");
		// 直接访问会报错，需要忽略访问权限修饰符的安全检查
		d.setAccessible(true); // 暴力反射
		Object value2 = d.get(p);
		System.out.println(value2);
	}
}
