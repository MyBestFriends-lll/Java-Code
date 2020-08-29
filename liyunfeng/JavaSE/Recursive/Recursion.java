package Recursive;
/*
递归：方法自己调用自己
递归的分类：
	直接递归，和间接递归
	直接递归：方法自身调用自己
	间接递归：A 调用 B，B 调用 C，C 调用 A
注意事项：
	递归一定要有条件限制，保证递归能过停下来，否则会发生栈内存溢出
	Exception in thread "main" java.lang.StackOverflowError
	递归次数不能太多，否则也会发生栈内存溢出
	构造方法，禁止递归
使用前提：当调用方法时，方法的主体不变，每次调用方法的参数不同，可以使用递归
 */
public class Recursion {
	public static void main(String[] args) {
		a();
	}

	private static void a() {
		a();
	}
}
