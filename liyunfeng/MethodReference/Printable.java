package MethodReference;
/*
定义一个函数式接口
 */
@FunctionalInterface
public interface Printable {
	// 定义字符串的抽象方法
	public abstract void print(String s);
}
