package FunctionalProgramming.supplier;

import java.util.function.Supplier;

/*
练习：求数组元素的最大值
	使用Supplier 接口作为方法参数类型，通过Lambda 表达式求出int 数组中的最大值
	提示：接口的泛型使用java.lang.Integer类
 */
public class Exercise {
	public static int getMax(Supplier<Integer> sup) {
		return sup.get();
	}

	public static void main(String[] args) {
		// 定义一个int 类型的数组并赋值
		int[] arr = {2, 28, 23, 13, 8, 17};
		// 调用getMax 方法，方法的参数Supplier 是一个函数式接口，所以传递Lambda 表达式
		int max = getMax(() -> {
			int tmpmax = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > tmpmax) {
					tmpmax = arr[i];
				}
			}
			return tmpmax;
		});
		System.out.println(max);
	}
}
