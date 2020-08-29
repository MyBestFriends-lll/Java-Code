package List;

import java.util.*;

/*
java.util.List 接口 extends Collection 接口
List 接口特点：
    1. 有序的集合，存储元素和取出元素的顺序是一致的
    2. 有索引，包含了一些带索引的方法
    3. 允许存储重复元素
带索引的方法：
    public void add(int index, E element)
    public E get(int index)
    public E remove(int index)
    public E set(int index, E element)
注意：操作索引时，防止索引越界异常
 */
public class list {
    public static void main(String[] args) {
        // 创建List对象 使用多态
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        System.out.println(list); // [a, b, c, a]

        list.add(3, "Java");
        System.out.println(list); // [a, b, c, Java, a]

        String remove = list.remove(2);
        System.out.println("被移除的元素是：" + remove);
        System.out.println(list); // [a, b, Java, a]

        String setElement = list.set(3, "Hello");
        System.out.println("被替换的元素是：" + setElement);
        System.out.println(list); // [a, b, Java, Hello]

        /*
            使用for循环、迭代器、增强for循环可以遍历集合
         */
    }
}
