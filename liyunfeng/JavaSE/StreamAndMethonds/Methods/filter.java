package StreamAndMethonds.Methods;

import java.util.stream.Stream;

/*
可以通过filter 方法将一个流转换成另一个子集流
	Stream<T> filter(Predicate<? super T> predicate);
Stream 流中的常用方法 filter ：永福对Stream 流中的数据进行过滤
filter 方法的参数Predicate 是一个函数式接口，所以可以传递Lambda 表达式，对数据进行过滤
Predicate 中的抽象方法：
	boolean test(T t);
 */
public class filter {
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
		// 对stream1 流中的元素进行过滤，只保留姓张的
		Stream<String> stream2 = stream1.filter((String name) -> {
			return name.startsWith("张");
		});
		// 遍历stream2 流
		stream2.forEach(name -> System.out.println(name));
	}
}
