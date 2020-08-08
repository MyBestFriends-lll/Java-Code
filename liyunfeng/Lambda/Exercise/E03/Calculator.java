package Lambda.Exercise.E03;
/*
Lambda 表达式有参数有返回值的练习
需求：
	给定一个计算器Calculator 接口，内含方法calc 可以将两个int 数字相加得到和
	使用Lambda 的标准格式调用invokeCalc 方法，完成120和130的相加计算
 */
public interface Calculator {
	public abstract int calc(int a, int b);
}
