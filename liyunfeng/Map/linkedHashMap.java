package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
java.util.LinkedHashMap<K, V> extends HashMap<K, V>
Map 接口的哈希表和连接列表实现，具有可预知的迭代顺序
 */
public class linkedHashMap {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "a");
		map.put("c", "c");
		map.put("b", "b");
		map.put("a", "d");
		System.out.println(map); // key 不允许重复，无序存储

		LinkedHashMap<String, String> linkedmap = new LinkedHashMap<>();
		linkedmap.put("a", "a");
		linkedmap.put("c", "c");
		linkedmap.put("b", "b");
		linkedmap.put("a", "d");
		System.out.println(linkedmap); // key 不允许重复，有序存储
	}
}
