import java.util.*;
/*
JDK9 的新特性：
	List 接口，Set 接口，Map 接口里面增加一个静态方法 of ，可以给集合一次性添加多个元素
	static <E> List<E> of (E... elements)
	static <E> Set<E> of (E... elements)
	static <E> Map<E> of (E... elements)
	使用前提：当集合中存储的元素的个数已经确定了，并且不再改变时使用
注意：
	1. of 方法只适用于List 接口，Set 接口，Map 接口，不适用于接口的实现类（HashMap HashSet ArrayList...）
	2. of 方法的返回值是一个不能改变的集合，集合不能再使用add put 方法添加元素，会抛出异常
	3. Set 接口和Map 接口在调用of 方法的时候，不能用重复的元素，否则会抛出异常
 */
public class jdk9New {
	public static void main(String[] args) {
		List<String> list = List.of("a", "b", "c", "a", "d");
		System.out.println(list); // [a, b, c, a, d]
		// list.add("a"); // UnsupportedOperationException：不支持操作异常

		// Set<String> set = Set.of("a", "b", "c", "a", "d");
		// System.out.println(set); // IllegalArgumentException: 非法参数异常，有重复的元素 duplicate element: a
		Set<String> set = Set.of("a", "b", "c", "d");
		System.out.println(set); // [b, c, d, a]
		// set.add("a"); // UnsupportedOperationException：不支持操作异常

		// Map<String, Integer> map = Map.of("Tom", 3, "Jerry", 8, "Miffy", 10, "Tom", 9);
		// System.out.println(map); // IllegalArgumentException: 非法参数异常，有重复的元素 duplicate key: Tom
		Map<String, Integer> map = Map.of("Tom", 3, "Jerry", 8, "Miffy", 10);
		System.out.println(map); // {Jerry=8, Miffy=10, Tom=3}
		// map.put("Hu", 7); // UnsupportedOperationException：不支持操作异常

	}
}
