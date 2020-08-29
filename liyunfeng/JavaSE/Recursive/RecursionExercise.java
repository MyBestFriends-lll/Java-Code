package Recursive;
/*
递归练习：1～n之间的和
 */
public class RecursionExercise {
	static int s = 0;
	public static void main(String[] args) {
		// sum(3);
		System.out.println("和：" + sum(3));
	}

	/*private static void sum(int i) {
		s = s + i;
		if (i > 0) {
			sum(-- i);
		} else {
			System.out.println("和：" + s);
			return;
		}
	}*/

	// 通过获取下一个被加的数字
	public static int sum(int i) {
		if (i == 1) {
			return 1;
		}
		return i + sum(-- i);
	}
}
