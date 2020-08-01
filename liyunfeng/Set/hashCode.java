package Set;
/*
哈希值：是一个十进制整数，由系统随机给出（就是对象的地址，是一个逻辑地址，是模拟出来的地址，不是数据实际存储的物理地址）
在Object 类有一个方法可以获取对象的哈希值 int hashCode()
public native int hashCode();
native: 代表该方法调用的是本地操作系统的方法
 */
public class hashCode {
    public static void main(String[] args) {
        // Person 继承了Object 类，所以可以使用Object 类的hashCode 方法
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        /*
            toString:
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
            hashCode 的十六进制表示就是toString 打印出的地址
         */
        System.out.println(p1);
        System.out.println(p2);

        /*
            String 类的哈希值（特殊）
                String 类重写了 Object 类的hashCode 方法
         */
        String s1 = new String("abc");
        String s2 = new String("abc");
        // hashCode 一样
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

// class Person extends Object {
//     /*
//         可以重写hashCode 方法
//      */
//     /*@Override
//     public int hashCode() {
//         return 1;
//     }*/
// }