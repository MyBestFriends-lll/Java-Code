package MethodReference.ByClassConstructor;
/*
定义一个创建Person 对象的函数式接口
 */
@FunctionalInterface
public interface PersonBuilder {
	// 定义一个方法，根据传递的姓名，创建Person 对象返回
	public abstract Person buildPerson(String name);
}
