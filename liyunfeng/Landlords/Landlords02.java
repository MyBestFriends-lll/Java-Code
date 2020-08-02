package Landlords;

import java.util.*;

/*
斗地主简单实现，有序版本
 */
public class Landlords02 {
	public static void main(String[] args) {
		// 1. 准备
		// 创建一个Map 集合，存储牌的索引和组装好的牌
		HashMap<Integer, String> poker = new HashMap<>();
		// 创建一个List 集合，存储牌的索引
		ArrayList<Integer> pokerIndex = new ArrayList<>();
		// 定义两个集合，存储花色和序号
		List<String> colors = List.of("黑桃", "梅花", "红桃", "方块");
		List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
		// 先存储大王/小王
		int index = 0;
		poker.put(index, "\uF578"); // 大王
		pokerIndex.add(index);
		index ++;
		poker.put(index, "\uF58D"); // 小王
		pokerIndex.add(index);
		index ++;
		// 循环遍历两个集合，组装52张牌，存储到集合中
		for (String number : numbers) {
			for (String color : colors) {
				poker.put(index, color+number);
				pokerIndex.add(index);
				index ++;
			}
		}
		// System.out.println(poker);
		// System.out.println(pokerIndex);

		// 2. 洗牌
		Collections.shuffle(pokerIndex);
		// System.out.println(pokerIndex);

		// 3. 发牌
		ArrayList<Integer> player01 = new ArrayList<>();
		ArrayList<Integer> player02 = new ArrayList<>();
		ArrayList<Integer> player03 = new ArrayList<>();
		ArrayList<Integer> diPai = new ArrayList<>();

		for (int i = 0; i < pokerIndex.size(); i++) {
			Integer in = pokerIndex.get(i);

			if (i >= 51) {
				diPai.add(in);
			} else if (i % 3 == 0) {
				player01.add(in);
			} else if (i % 3 == 1) {
				player02.add(in);
			} else if (i % 3 == 2) {
				player03.add(in);
			}
		}

		// 4. 排序
		Collections.sort(player01);
		Collections.sort(player02);
		Collections.sort(player03);
		Collections.sort(diPai);

		// 5. 看牌
		look("player01", poker, player01);
		look("player02", poker, player02);
		look("player03", poker, player03);
		look("底牌", poker, diPai);
	}

	public static void look(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
		// 输出玩家名称不换行
		System.out.print(name + ": ");
		// 遍历玩家或者底牌集合，获取牌的索引
		for (Integer key : list) {
			// 使用牌的索引去Map 集合中找到对应的牌
			String value = poker.get(key);
			System.out.print(value + ", ");
		}
		// 打印完一个换行
		System.out.println();
	}
}
