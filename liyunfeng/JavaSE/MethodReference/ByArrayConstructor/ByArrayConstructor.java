package MethodReference.ByArrayConstructor;
/*
数组的构造器的引用
 */
public class ByArrayConstructor {
	/*
		定义一个方法，参数传递创建数组的长度和ArrayBuilder 接口
		方法内部根据传递的长度使用ArrayBuilder 中的方法创建数组并返回
	 */
	public static int[] createArray(int length, ArrayBuilder ab) {
		return ab.buildArray(length);
	}

	public static void main(String[] args) {
		// 调用createArray 方法，传递数组的长度和Lambda 表达式
		int[] arr1 = createArray(10, (length) -> {
			return new int[length];
		});
		System.out.println(arr1.length);

		/*
			使用方法引用优化Lambda 表达式
			已知创建的就是int[]
			数组的长度也是已知的
			就可以使用方法引用
			int[] 引用new 根据参数传递的长度来创建 数组
		 */
		int[] arr2 = createArray(10, int[]::new);
		System.out.println(arr2.toString());
		System.out.println(arr2.length);
	}
}
