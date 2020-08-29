# *Lambda* 的使用前提
Lambda 的语法非常简洁，完全没有面向对象复杂的束缚。但是使用时有几个问题需要注意：
1. 使用Lambda 必须有接口，且要求**接口中有且仅有一个抽象方法**  
    无论是JDK 内置的`Runnable`、`Comparator`接口还是自定义接口，只有当接口中的抽象方法存在且唯一时才可以使用Lambda

2. 使用Lambda 必须具备**上下文推断**  
    也就是方法的参数或局部变量类型必须为Lambda 对应的接口类型， 才能使用Lambda 作为改接口的实例
> 备注：有且仅有一个抽象方法的接口，称为“函数式接口”。

## *Lambda* 表达式
*可推导，可省略*

凡是根据上下文推导出来的内容，都可以省略书写  
可以省略的内容：  
1. （参数列表）：括号中参数列表的数据类型，可以省略不写  
2. （参数列表）：括号中的参数如果只有一个，那么类型和`( )`都可以省略
3. {一些代码}：如果`{ }`中的代码只有一行，无论是否有返回值，都可以省略（`{ }`，`returt` `分号`）  
> 注意：要省略`{ }`，`return`和`分号`必须一起省略

```java
public class Demo {
    public static void main(String[] args){
        // JDK1.7 版本之前，创建集合对象必须把前后的泛型都写上
        ArrayList<String> list01 = new ArrayList<String>();
        // JDk1.7 版本之后，= 号右边的泛型可以省略，后面的泛型可以根据前面的泛型推导出来
        ArrayList<String> list02 = new ArrayList<>();
        
        // Lambda 省略示例
        // 使用Lambda 表达式实现多线程
        new Thread( () -> {
            System.out.println(Thread.currentThread().getName() + " -> 新线程创建了");
        }).start();
        new Thread( () -> System.out.println(Thread.currentThread().getName() + " -> 新线程创建了")).start();
        
        // 使用Lambda 表达式，简化匿名内部类的重写
		invokeCook(() -> {
			System.out.println("Lambda: 吃饭啦！");
		});
        invokeCook(() -> System.out.println("Lambda: 吃饭啦！"));
        
        // Person 类
        Arrays.sort(arr, (o1, o2) -> {
			return o1.getAge() - o2.getAge();
		});
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());
    }
}
```
