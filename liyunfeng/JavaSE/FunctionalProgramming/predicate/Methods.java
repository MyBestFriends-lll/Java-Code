package FunctionalProgramming.predicate;

import java.util.function.Predicate;

/*
逻辑表达式：&& || !
需求：判断一个字符串，有两个判断条件
	1. 长度大于5
	2. 包含a
可以使用&& 运算符连接两个条件
Predicate 接口中有一个方法and 表示并且关系，也可以用于连接两个判断条件
default Predicate<T> and(Predicate<? super T> other) {
	Objects.requireNonNull(other);
	return (t) -> test(t) && other.test(t);
	// return (t) -> this.test(t) && other.test(t);
}
方法内部的两个判断条件也是用&& 运算符连接的
 */
public class Methods {
	/*
		定义一个方法，参数传递一个字符串两个Predicate 接口，一个判断长度，一个判断是否包含
		两个条件必须同时满足
	 */
	public static boolean checkand(String s, Predicate<String> pre1, Predicate<String> pre2) {
		// && 与运算
		/*
			default Predicate<T> and(Predicate<? super T> other) {
		        Objects.requireNonNull(other);
		        return (t) -> test(t) && other.test(t);
		        // return (t) -> this.test(t) && other.test(t);
		    }
		 */
		return pre1.and(pre2).test(s);
	}

	public static boolean checkor(String s, Predicate<String> pre1, Predicate<String> pre2) {
		// || 或运算
		/*
			default Predicate<T> or(Predicate<? super T> other) {
		        Objects.requireNonNull(other);
		        return (t) -> test(t) || other.test(t);
		        // return (t) -> this.test(t) || other.test(t);
		    }
		 */
		return pre1.or(pre2).test(s);
	}

	public static boolean checknegate(String s, Predicate<String> pre1) {
		// ! 非运算
		/*
			default Predicate<T> negate() {
		        return (t) -> !test(t);
		    }
		 */
		return pre1.negate().test(s);
	}

	public static void main(String[] args) {
		String str1 = "abcdef";
		String str2 = "bcdefg";
		String str3 = "abcdef";
		boolean b1 = checkand(str1,
				(String s) -> {
					return s.length() > 5;
				},
				(String s) -> {
					return s.contains("a");
				});
		System.out.println("and -> " + b1);

		boolean b2 = checkor(str2,
				(String s) -> {
					return s.length() > 5;
				},
				(String s) -> {
					return s.contains("a");
				});
		System.out.println("or -> " + b2);

		boolean b3 = checknegate(str3, (String s) -> {
			return s.length() > 5;
		});
		System.out.println("negate -> " + b3);
	}
}
