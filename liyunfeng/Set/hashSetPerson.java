package Set;

import java.util.HashSet;

/*
HashSet 存储自定义类型元素
Set 集合保存元素唯一：存储的元素（String, Integer, ..., Student, Person）必须重写hashCode 和 equals 方法
要求：
    同名同年龄的视为同一个人，只能存储一次
 */
public class hashSetPerson {
    public static void main(String[] args) {
        HashSet<Person> setPerson = new HashSet<>();
        Person p1 = new Person("Tom", 20);
        Person p2 = new Person("Tom", 20);
        Person p3 = new Person("Tom", 22);
        setPerson.add(p1);
        setPerson.add(p2);
        setPerson.add(p3);
        System.out.println(setPerson);
    }
}
