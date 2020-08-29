package MethodReference.ByThis;
/*
定义一个“富有的” 函数式接口
 */
@FunctionalInterface
public interface Richable {
	// 定义一个想买什么就买什么的方法
	public abstract void buy();
}
