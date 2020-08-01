package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
java.util.Set 接口 extends Collection 接口
Set 接口的特点：
    1. 不允许存储重复的元素
    2. 没有索引，没有带索引的方法，也不能使用普通的for循环遍历
java.util.HashSet 集合 implements Set 接口
HashSet 接口的特点：
    1. 不允许存储重复的元素
    2. 没有索引，没有带索引的方法，也不能使用普通的for循环遍历
    3. 是一个无序的集合，存储和取出元素的顺序可能不一样
    4. 底层是一个哈希表结构（查询速度非常快）
 */
public class hashSet {
    public static void main(String[] args) {
        // 创建HashSet对象 使用多态
        Set<Integer> set = new HashSet<>();
        // 添加元素
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // 不允许重复的元素
        // 使用迭代器遍历 / 增强for循环
        Iterator<Integer> set_it = set.iterator();
        while (set_it.hasNext()) {
            System.out.println(set_it.next()); // 1, 2, 3
        }
    }
}
