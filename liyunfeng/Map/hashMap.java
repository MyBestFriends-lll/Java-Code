package Map;

import java.util.*;

/*
Map 集合
    java.util.Map<K, V> 集合
    Map 集合的特点：
        1. Map 集合是一个双列集合， 一个元素包含两个值（一个key，一个value）
        2. Map 集合中的元素，key 和 value 的数据类型可以相同，也可以不同
        3. Map 集合中的元素，key 是不允许重复的，value 是可以重复的
        4. Map 集合中的元素，key 和 value 是一一对应的
Map 集合常用子类
    java.util.HashMap<K, V> 集合 implements Map<K, V> 接口
    HashMap 集合的特点：
        1. HashMap 集合底层是哈希表：查询的速度特别快
            JDK1.8 之前：数组 + 单向链表
            JDK1.8 之后：数组 + 单向链表/红黑树（链表的长度超过8）：提高查询的速度
        2. HashMap 集合是一个无序的集合，存储元素和取出元素的顺序可能不一致
    java.util.LinkedHashMap<K, V> 集合 extends HashMap<K, V> 集合
    LinkedHashMap 的特点：
        1. LinkedHashMap 集合底层是哈希表 + 链表（保证迭代的顺序）
        2. LinkedHashMap 集合是一个有序的集合，存储元素和取出元素的顺序是一样的
 */
public class hashMap {
	public static void main(String[] args) {
		// mapAdd();
		// mapRemove();
		// mapGet();
		mapContainsKey();
	}

	private static void mapContainsKey() {
		Map<String, Integer> map = new HashMap<>();
		map.put("key 1", 1);
		map.put("key 2", 2);
		map.put("key 3", 3);
		boolean b1 = map.containsKey("key 1");
		System.out.println(b1); // 存在对应的key 返回true
		boolean b2 = map.containsKey("key 4");
		System.out.println(b2); // 不存在对应的key 则返回false
		// containsValue 类似
		boolean b3 = map.containsValue(1);
		System.out.println(b3);
		boolean b4 = map.containsValue(4);
		System.out.println(b4);
	}

	private static void mapGet() {
		Map<String, Integer> map = new HashMap<>();
		map.put("key 1", 1);
		map.put("key 2", 2);
		map.put("key 3", 3);
		Integer get1 = map.get("key 3");
		System.out.println(get1); // key 存在返回对应的value
		Integer get2 = map.get("key 4");
		System.out.println(get2); // key 不存在返回null
	}

	private static void mapRemove() {
		Map<String, Integer> map = new HashMap<>();
		map.put("key 1", 1);
		map.put("key 2", 2);
		map.put("key 3", 3);
		System.out.println(map);
		Integer re1 = map.remove("key 2");
		System.out.println("被删除的key的value是：" + re1); // key 存在返回被删除的元素
		Integer re2 = map.remove("key 4");
		System.out.println("被删除的key的value是：" + re2); // key 不存在返回null
		System.out.println(map);
	}

	private static void mapAdd() {
		// key 不允许重复，value 可以，如果key 重复会被替换
		Map<String, String> map = new HashMap<>();
		String val1 = map.put("key 1", "value 1");
		System.out.println(val1); // 没有相同的key 时返回null
		String val2 = map.put("key 1", "value 2");
		System.out.println(val2); // 重复的key 时返回被替换的value
		System.out.println(map); // print map
		map.put("key 2", "value 3");
		map.put("key 3", "value 2");
		map.put("key 4", "value 4");
		System.out.println(map);
	}
}
