package List;

import java.util.*;

/*
java.util.LinkedList 集合 implements List 接口
LinkedList 集合的特点：
    1. 底层是一个链表的结构：查询慢，増删快
    2. 里面包含了大量操作首尾元素的方法
注意：使用LinkedList 集合特有的方法不能使用多态

public void    addFirst(E e)
public void    addLast(E e)
public E       getFirst()
public E       getLast()
public E       removeFirst()
public E       removeLast()
public E       pop()
public void    push(E e)
public boolean isEmpty()
 */
public class linkedList {
    public static void main(String[] args) {
        linkedAdd();
        linkedGet();
        linkedRemove();
    }

    private static void linkedRemove() {
        // 创建LinkedList 对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.addFirst("addFirst");
        linked.addLast("addLast");
        linked.push("push");

        System.out.println("被移除的第一个元素：" + linked.removeFirst());
        System.out.println("被移除的最后一个元素：" + linked.removeLast());
        System.out.println("被pop的元素：" + linked.pop());
        System.out.println(linked);
    }

    private static void linkedGet() {
        // 创建LinkedList 对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.addFirst("addFirst");
        linked.addLast("addLast");
        linked.push("push");

        linked.clear(); // 清空集合里的元素

        if (!linked.isEmpty()) {
            System.out.println("集合的第一个元素：" + linked.getFirst());
            System.out.println("集合的最后一个元素：" + linked.getLast());
        }
        System.out.println("集合被清空了");
    }

    private static void linkedAdd() {
        // 创建LinkedList 对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.addFirst("addFirst");
        linked.addLast("addLast");
        linked.push("push");
        System.out.println(linked);
    }
}
