package MethodReference.ByObject;

/*
通过对象名引用成员方法，使用前提是对象已经存在，成员方法也已经存在
就可以使用对象名来引用成员方法
 */
public class MethodReferenceByObject {
	// 定义一个方法，参数传递Printable 接口，对字符串进行打印
	public static void printString(Printable p) {
		p.print("Hello World");
	}

	public static void main(String[] args) {
		MethodObject mo = new MethodObject();
		printString((s) -> {
			System.out.println(s.toUpperCase());
		});
		printString(mo::printUpper);
	}
}
