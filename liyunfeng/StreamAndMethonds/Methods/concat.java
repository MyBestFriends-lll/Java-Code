package StreamAndMethonds.Methods;

import java.util.stream.Stream;

/*
Stream 流中常用的方法concat ：用于把流组合到一起
如果有两个流，希望合并成一个流，那么可以使用Stream 流接口的静态方法concat
static <T> Stream<T> concat(Stream<? extends T> a, Stream<? Extends T> b)
 */
public class concat {
	public static void main(String[] args) {
		// 创建两个Stream 流
		Stream<String> stream1 = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
		String[] arr = {"Tom", "Jerry", "Miffy", "Caff", "Jessi"};
		Stream<String> stream2 = Stream.of(arr);
		// 把两个流合并成一个流
		Stream<String> concat = Stream.concat(stream1, stream2);
		// 遍历concat 流
		concat.forEach(name -> System.out.println(name));
	}
}
