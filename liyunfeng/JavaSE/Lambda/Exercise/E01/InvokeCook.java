package Lambda.Exercise.E01;
/*
练习：使用Lambda 标准格式（无参数无返回值）
题目：给定一个厨子Cook 接口，内含唯一的抽象方法makeFood ，且无参数无返回值
请使用Lambda 标准格式调用invokeCook 方法打印输出“吃饭啦！“字样
 */
public class InvokeCook {
	public static void main(String[] args) {
		// 之前的方法
		// 调用invokeCook 方法参数是Cook 接口，传递Cook 接口的匿名内部类对象
		invokeCook(new Cook() {
			@Override
			public void makeFood() {
				System.out.println("Normal: 吃饭啦！");
			}
		});

		// 使用Lambda 表达式，简化匿名内部类的重写
		invokeCook(() -> {
			System.out.println("Lambda: 吃饭啦！");
		});
	}

	private static void invokeCook(Cook cook) {
		cook.makeFood();
	}
}
