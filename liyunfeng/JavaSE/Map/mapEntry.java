package Map;

import java.util.*;

/*
Map 集合的第二种遍历方式：使用Entry 对象遍历
Map 集合中的方法：Set<Map.Entry<K, V> > entrySet() 返回此映射中包含的映射关系的 Set 视图
步骤：
	1. 使用Map 集合中的方法entrySet()，把Map 集合中的多个Entry 对象取出来，存储到一个Set 集合中
	2. 遍历Set 集合，获取每一个Entry 对象
	3. 使用Entry 对象中的方法getKey() / getValue() 获取key & value
 */
public class mapEntry {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("key 1", 1);
		map.put("key 2", 2);
		map.put("key 3", 3);

		// 使用entrySet方法，获取Entry对象，存储到Set集合中
		Set<Map.Entry<String, Integer> > mapSet = map.entrySet();

		// 遍历
		Iterator<Map.Entry<String, Integer> > it = mapSet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println((key + " -> " +value));
		}
		System.out.println("-----------------");
		for (Map.Entry<String, Integer> entry : mapSet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println((key + " -> " +value));
		}
	}
}
