package StreamAndMethonds.Methods;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
Stream 流中的常用方法count ：用于统计Stream 流中元素的个数，是一个终结方法
long count();
所以不能继续调用Stream 流中的其他方法了
 */
public class count {
	public static void main(String[] args) {
		// 获取一个Stream 流
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 7; i ++) {
			list.add(i);
		}
		Stream<Integer> stream = list.stream();
		long count = stream.count();
		System.out.println(count);
	}
}
