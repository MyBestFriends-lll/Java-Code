package StreamAndMethonds.Methods;

import java.util.stream.Stream;

/*
Stream 流中的常用方法limit ：用于截取流中的元素
limit 方法可以对流进行截取，只取前n 个。方法签名：
Stream<T> Limit(long maxSize);
	参数是一个long 型，如果集合当前长度大于参数则进行截取；否则不进行操作
limit 方法是一个延迟方法，只是对流中的元素进行截取，返回的是一个新的流，所以可以继续调用Stream 流中的其他方法
 */
public class limit {
	public static void main(String[] args) {
		// 获取一个Stream 流
		String[] arr = {"Tom", "Jerry", "Miffy", "Caff", "Jessi"};
		Stream<String> stream = Stream.of(arr);
		// 使用limit 对stream 流中的元素进行截取，只要前3个元素
		Stream<String> stream2 = stream.limit(3);
		// 遍历stream2 流
		stream2.forEach(name -> System.out.println(name));
	}
}
