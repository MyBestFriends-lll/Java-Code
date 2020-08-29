package Map;

import java.util.*;

/*
Map 集合的第一种遍历方式：通过key 找value 的方式
Map 集合中的方法：Set<K> keySet() 返回此映射中包含的key 的Set 视图
步骤：
	1. 使用Map 集合中的方法keySet()，把Map 集合所有的key 取出来，存储到一个Set集合中
	2. 遍历Set 集合，获取Map 集合中的每一个key
	3. 通过Map 集合中的方法get(key)，通过key 找到对应的value
 */
public class mapKeySet {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("key 1", 1);
		map.put("key 2", 2);
		map.put("key 3", 3);
		Set<String> mapSet = map.keySet();
		// 使用迭代器遍历，获取对应的value
		/*Iterator<String> it = mapSet.iterator();
		while (it.hasNext()) {
			Integer mapInt = map.get(it.next());
			System.out.println(mapInt);
		}*/

		// 使用增强for
		for (String s : mapSet) {
			System.out.println(map.get(s));
		}
	}
}
