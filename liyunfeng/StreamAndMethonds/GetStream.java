package StreamAndMethonds;

import java.util.*;
import java.util.stream.Stream;

/*
java.util.stream 包中的Stream<T> 是Java 8新加入的最常用的流接口。（这并不是一个函数式接口）
获取一个流非常简单，有以下几种常用方式：
	所有的Collection 集合都可以通过stream 默认方法获取流。
		default Stream<E> stream()
	Stream 接口的静态方法of 可以获取数组对应的流
		static <T> Stream<T> of(T... value)
		参数是一个可变参数，那么就可以传递一个数组
 */
public class GetStream {
	public static void main(String[] args) {
		// 把集合转换为Steram 流
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();

		Set<String> set = new HashSet<>();
		Stream<String> stream2 = set.stream();

		Map<String, String> map = new HashMap<>();
		// 获取键 key，存储到一个Set 集合中
		// 间接转换
		Set<String> mapSet = map.keySet();
		Stream<String> stream3 = mapSet.stream();
		// 获取值 value
		Collection<String> values = map.values();
		Stream<String> stream4 = values.stream();
		// 获取键值对（key & value)，键与值的映射关系entrySet
		Set<Map.Entry<String, String>> entries = map.entrySet();
		Stream<Map.Entry<String, String>> stream5 = entries.stream();

		// 把数组转换为Stream 流
		Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
		// 可变参数可以传递数组
		Integer[] arr1 = {1, 2, 3, 4, 5};
		Stream<Integer> stream7 = Stream.of(arr1);
		String[] arr2 = {"a", "bb", "ccc", "dddd"};
		Stream<String> stream8 = Stream.of(arr2);
	}
}
