package Map;

import java.util.HashMap;
import java.util.Scanner;

/*
Map exercise：计算一个字符串中每个字符出现的次数
 */
public class mapExercise {
	public static void main(String[] args) {
		// 获取输入的字符串
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a string: ");
		String input = sc.next();
		// 创建一个Map 集合
		HashMap<Character, Integer> map = new HashMap<>();
		// 遍历字符串
		for (char c : input.toCharArray()) {
			// 判断字符是否在集合中
			if (map.containsKey(c)) {
				// key 存在
				Integer value = map.get(c);
				value ++;
				map.put(c, value);
			} else {
				// key 不存在
				map.put(c, 1);
			}
		}
		// 输出集合，查看结果
		for (Character key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}
}
