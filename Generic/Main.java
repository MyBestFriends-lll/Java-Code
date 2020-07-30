package Generic;

public class Main {
    public static void main(String[] args) {
        /*
            泛型类
         */
        GenericClass<String> ge = new GenericClass<>();
        ge.setData("My name");
        System.out.println(ge.getData());

        GenericClass<Integer> ge2 = new GenericClass<>();
        ge2.setData(20);
        System.out.println(ge2.getData());

        System.out.println("-----------------");

        /*
            泛型方法
         */
        GenericMethod gm = new GenericMethod();
        gm.method(20);
        gm.method("My name");
        gm.method(7.3);

        System.out.println("-----------------");

        gm.s_method("静态方法，不建议通过创建对象使用");
        GenericMethod.s_method(20);
        GenericMethod.s_method("静态方法，通过类名.方法名调用");

        System.out.println("-----------------");

        /*
            泛型接口
         */
        GenericInterfaceImpl gi = new GenericInterfaceImpl();
        gi.method("使用接口重写实现的方法");

        GenericInterfaceImpl2<String> gi2 = new GenericInterfaceImpl2<>();
        gi2.method("My name");
        GenericInterfaceImpl2<Integer> gi3 = new GenericInterfaceImpl2<>();
        gi3.method(20);
    }
}
