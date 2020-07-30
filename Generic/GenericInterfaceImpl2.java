package Generic;
/*
含有泛型的接口的第二种使用方式：接口使用什么泛型，实现类就使用什么泛型，类跟着接口走
相当于定义了一个含有泛型的类，创建对象的时候确定泛型的类型
 */
public class GenericInterfaceImpl2<E> implements GenericInterface<E> {
    @Override
    public void method(E data) {
        System.out.println(data);
    }
}
