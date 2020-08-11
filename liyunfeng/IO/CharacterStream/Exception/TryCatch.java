package IO.CharacterStream.Exception;

import java.io.*;

/*
在JDk1.7 之前使用try...catch...finally 处理流中得异常
格式：
	try {
		...
	} catch(异常类变量 变量名) {
		...
	} finally {
		...
	}
 */
public class TryCatch {
	public static void main(String[] args) {
		// 提高变量fw 的作用域让finally 可以使用
		// 变量在定义的时候，可以没有值，但是使用得时候必须有值
		FileWriter fw = null;
		try {
			// 可能产生异常的代码
			fw = new FileWriter("./src/IO/in.txt");
			// void write(char[] cbuf) 写入字符数组
			char[] chars = {'a', 'b', 'c', '\n'};
			fw.write(chars);
		} catch (IOException e) {
			// 异常的处理逻辑
			// e.printStackTrace();
			System.out.println(e);
		} finally {
			// 一定会执行的代码
			// fw.flush();
			// close 方法声明抛出了IOException 异常对象，所以我们就必须处理这个异常对象，要么throws，要么try...catch
			// 如果创建对象失败了，fw 默认值就是null，会抛出NullPointerException 需要增加一个判断
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
