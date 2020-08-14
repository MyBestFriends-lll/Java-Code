package FunctionalProgramming;
/*
函数式接口：<有> 且 <只有> 一个 <抽象> 方法的接口，称之为函数式接口
接口中也可以包含其他的方法（默认，静态，私有）
@FunctionalInterface 注解
作用：检测接口是否是一个函数式接口
 */
@FunctionalInterface
public interface MyFunctionalInterface {
	// 定义一个抽象方法
	public abstract void method();
	// 第二个抽象方法
	// 有两个抽象方法就不是函数式接口了
	// void method2();
}
