package Exception;

/*
throw 关键字作用：
	可以使用throw 关键字在指定方法中抛出指定的异常
使用格式：
	throw new xxxException("异常产生的原因");
注意：
	1. throw 关键字必须写在方法的内部
	2. throw 关键字后面new 的对象必须是Exception 或者Exception 的子类对象
	3. throw 关键字抛出指定的异常对象，我们就必须处理这个异常对象
		throw 关键字后面创建的是RuntimeException 或者是RuntimeException 的子类对象，我们可以不处理，默认交给JVM处理（打印异常对象，中断程序）
		throw 关键字后面创建的是编译异常（写代码时候的报错），我们就必须处理这个异常，要么throws 要么try...catch
 */
public class Throw {
	public static void main(String[] args) {
		// int[] arr = null;
		int[] arr = new int[3];
		int e = getElement(arr, 3);
		System.out.println(e);
	}

	/*
		定义一个方法，获取数组指定索引处的元素
		参数：
			int[] arr
			int index
		以后（工作中）我们首先必须对方法传递的参数进行合法性校验
		如果参数不合法，就必须使用抛出异常的方式告知方法的调用者传递的参数有问题
	 */
	public static int getElement(int[] arr, int index) {
		/*
			对参数arr 进行合法性校验
			如果数组arr 是null 抛出空指针异常，告知“传递的数组的值是null”
			注意：NullPointerException 是一个运行时异常，可以不用处理默认交给JVM处理
		 */
		if (arr == null) {
			throw new NullPointerException("传递的数组是null");
		}

		/*
			对参数index 进行合法性校验
			如果index 不在数组索引范围内
			则抛出数组索引越界异常，告知调用者“传递的索引越界”
			也是运行时异常
		 */
		if (index < 0 || index > arr.length - 1) {
			throw new ArrayIndexOutOfBoundsException("传递的索引越界");
		}
		int ele = arr[index];
		return ele;
	}
}
