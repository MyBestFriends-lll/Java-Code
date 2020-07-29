package Iterator;

import java.util.*;

/*
java.util.Iterator 接口：迭代器（对集合进行遍历）
不知道和C++中的迭代器有什么不一样 （基本类似，只是多了一个判断是否有下一个元素的操作，无指向末尾的迭代器）
boolean hasNext()
E next()
Iterator迭代器是一个接口，无法直接使用，需要使用Iterator接口的实现类对象
Collection.iterator() 方法返回的就是迭代器的实现类
    Iterator<E> iterator() 返回在此 collection 的元素上进行迭代的迭代器
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        // 往集合中添加元素
        coll.add("Tom"); coll.add("Jerry"); coll.add("Miffy");
        // 获取迭代器 使用多态 前面是接口，后面是实现类对象
        Iterator<String> it = coll.iterator();

        // noLoop(it);

        // useLoop(it);

    }

    private static void useLoop(Iterator<String> it) {
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void noLoop(Iterator<String> it) {
        // 判断有没有下一个元素
        boolean b = it.hasNext();
        System.out.println(b);
        // 取出元素
        // 取到最后一个元素 的 后一个元素 进行判断为false，此时再进行next（取出）动作抛出异常
        // true Tom
        String s = it.next();
        System.out.println(s);

        // true Jerry
        b = it.hasNext();
        System.out.println(b);
        s = it.next();
        System.out.println(s);

        // true Miffy
        b = it.hasNext();
        System.out.println(b);
        s = it.next();
        System.out.println(s);

        // false [] 为false时取出则抛出异常
        b = it.hasNext();
        System.out.println(b);
        s = it.next();
        System.out.println(s);
    }
}
