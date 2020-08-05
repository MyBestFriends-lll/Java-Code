package Exception;

import java.util.Scanner;

/*
要求：模拟注册操作，如果用户名存在，则抛出异常并提示：该用户名已经存在
分析：
	1. 使用数组保存已经注册的用户名（数据库）
	2. 使用Scanner 获取用户输入的用户名（前端，页面）
	3. 定义一个方法，对用户输入的用户名进行判断
		遍历存储已经注册过的用户名的数组，获取每一个用户名
		使用获取到的用户名和用户输入的用户名进行比较
		true：用户名存在，抛出RegisterException 异常并提示
		false：继续遍历比较
		如果循环结束了还没有找到重复的则说明注册成功
 */
public class RegisterExceptionDemo {
	// 1. 使用数组保存已经注册的用户名（数据库）
	static String[] usernames = {"Tom", "Jerry", "Miffy"};
	public static void main(String[] args) /*throws RegisterException*/ {
		// 2. 使用Scanner 获取用户输入的用户名（前端，页面）
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要注册的用户名：");
		String username = sc.next();
		checkUsername(username);
	}

	private static void checkUsername(String username) /*throws RegisterException*/ {
		// 遍历存储已经注册过的用户名的数组，获取每一个用户名
		for (String name : usernames) {
			// 使用获取到的用户名和用户输入的用户名进行比较
			if (name.equals(username)) {
				// 注：如果是RuntimeException 可以不用处理，交给JVM处理即可
				try {
					throw new RegisterException("该用户名已存在");
				} catch (RegisterException e) {
					e.printStackTrace();
					return;
				}
			}
		}

		System.out.println("注册成功");
	}
}
