package UnitTesting.Test;

import UnitTesting.junit.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	/**
	 * 测试add 方法
	 */
	@Test
	public void testAdd() {
		// System.out.println("我被执行了");
		// 1. 创建计算器对象
		Calculator c = new Calculator();
		// 2. 调用add 方法
		int result = c.add(1, 2);
		System.out.println(result);
		// 很多时候并不能通过输出判断程序是否正确
		// 3. 断言 我断言这个结果是3
		Assert.assertEquals(3, result);
	}
}
