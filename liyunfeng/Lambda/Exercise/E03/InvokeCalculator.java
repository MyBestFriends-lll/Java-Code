package Lambda.Exercise.E03;

public class InvokeCalculator {
	public static void main(String[] args) {
		invokeCalc(10, 20, new Calculator() {
			@Override
			public int calc(int a, int b) {
				return a + b;
			}
		});

		// 使用Lambda 表达式简化匿名内部类的书写
		invokeCalc(10, 30, (int a, int b) -> {
			return a + b;
		});
	}
	/*
		定义一个方法
		参数传递两个int类型的整数
		参数传递Calculator 接口
		方法内部调用Calculator 中的方法calc 计算两个整数的和
	 */
	public static void invokeCalc(int a, int b, Calculator cal) {
		int sum = cal.calc(a, b);
		System.out.println(sum);
	}
}
