package StreamAndMethonds.Methods;

import java.util.stream.Stream;

/*
延迟方法：返回值类型仍然是Stream 接口自身类型的方法，因此支持链式调用。（除了终结方法外，其余方法均为延迟方法）
终结方法：返回值类型不再是Stream 接口自身类型的方法，因此不支持链式调用，count 和forEach 属于终结方法。

Stream 流中的常用方法 forEach
void forEach(Consumer<? super T> action);
该方法接收一个Consumer 接口函数，会将每一个流元素交给该函数进行处理
Consumer 是一个消费型函数式接口，可以传递Lambda 表达式操作数据
tips：forEach 方法用来遍历流中得数据，是一个终结方法，遍历之后不能继续调用Stream 流中的其他方法
 */
public class for_Each {
	public static void main(String[] args) {
		Stream<String> strStream = Stream.of("Tom", "Jerry", "Miffy");
		strStream.forEach((String s) -> {
			System.out.println(s);
		});
		// 使用终结方法以后不能再使用Stream 了
		// 否则抛出异常：java.lang.IllegalStateException: stream has already been operated upon or closed
		// 优化
		// strStream.forEach( s -> System.out.println(s) );
	}
}
