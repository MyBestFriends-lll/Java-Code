package Reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
案例：
	需求：写一个“框架”，可以帮我们创建任意类的对象，并且执行其中任意方法

框架类
前提：不能改变该类的任何代码，可以创建任意类的对象，可以执行任意方法
 */
public class Exercise {
	public static void main(String[] args) throws Exception {
		// 可以创建任意类的对象，可以执行任意方法
		/*Person p = new Person();
		p.eat();*/
		// 更改了类的代码
		/*Student stu = new Student();
		stu.sleep();*/

		// 1. 加载配置文件
		// 1.1 创建Properties 对象
		Properties pro = new Properties();
		// 1.2 加载配置文件，转换为一个集合
		// 1.2.1 获取Class 目录下的配置文件
		ClassLoader classLoader = Exercise.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("./Reflect/pro.properties");
		pro.load(is);

		// 2. 获取配置文件中定义的数据
		String className = pro.getProperty("className");
		String methodName = pro.getProperty("methodName");

		// 3. 加载该类进入内存
		Class cls = Class.forName(className);
		// 4. 创建对象
		Object obj = cls.newInstance();
		// 5. 获取方法对象
		Method method = cls.getMethod(methodName);
		// 6. 执行方法
		method.invoke(obj);
	}
}
