package Generic;
/*
定义泛型方法
格式：
    修饰符 <泛型> 返回值类型 方法名（参数列表[可使用泛型]） {
        方法体;
    }
 */
public class GenericMethod<E> {
    // 定义一个含有泛型的方法
    public <E> void method(E data) {
        System.out.println(data);
    }

    // 定义一个含有泛型的static（静态类型）方法
    public static <E> void s_method(E data) {
        System.out.println(data);
    }
}
