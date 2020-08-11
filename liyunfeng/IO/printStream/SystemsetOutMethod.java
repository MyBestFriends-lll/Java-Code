package IO.printStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
可以改变输出语句的目的地（打印流的流向）
输出语句默认在控制台输出
使用System.setOut 方法改变输出语句的目的地改为参数中传递的 打印流 的目的地
	static void setOut(PrintStream out) 重新分配“标准”输出流
 */
public class SystemsetOutMethod {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("控制台输出");
		PrintStream ps = new PrintStream("./src/IO/printStream/aa.txt");
		System.setOut(ps); // 把输出语句的目的地改变为打印流的目的地
		System.out.println("打印流的目的地中输出");
		ps.close();
	}
}
