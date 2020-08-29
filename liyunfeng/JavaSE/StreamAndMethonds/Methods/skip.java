package StreamAndMethonds.Methods;

import java.util.stream.Stream;

/*
Stream 流中的常用方法skip ：用于跳过元素
如果希望跳过前几个元素，可以使用skip 方法获取一个截取之后的新流：
Stream<T> skip(long n)
	如果流的当前长度大于n，则跳过前n 个；否则将会得到一个长度为0 的空流
 */
public class skip {
	public static void main(String[] args) {
		// 获取一个Stream 流
		String[] arr = {"Tom", "Jerry", "Miffy", "Caff", "Jessi"};
		Stream<String> stream = Stream.of(arr);
		// 使用skip 方法跳过前3个元素
		Stream<String> stream2 = stream.skip(3);
		// 遍历stream2 流
		stream2.forEach(name -> System.out.println(name));
	}
}
