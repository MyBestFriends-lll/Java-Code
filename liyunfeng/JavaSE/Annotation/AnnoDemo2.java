package Annotation;

import java.util.Date;

@SuppressWarnings("all")
public class AnnoDemo2 {
	@Override
	public String toString() {
		return super.toString();
	}

	@Deprecated
	public void show1() {
		// 有缺陷
	}

	@MyAnno(age = 20)
	public void show2() {
		// 代替show1方法
	}

	public void demo() {
		show1();
		Date date = new Date();
	}
}
