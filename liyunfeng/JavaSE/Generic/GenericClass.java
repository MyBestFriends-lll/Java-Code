package Generic;
/*
    定义一个泛型类
 */
public class GenericClass<E> {
    private E data;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
