package Java_.MianShiTi.JiChu;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: sy
 * @CreateTime: 2025-01-08
 * @Description: 测试 BigDecimal
 * @Version: 1.0
 */


public class BigDecimalDemo {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("1.0");
		BigDecimal b = new BigDecimal("0.9");
		BigDecimal c = new BigDecimal("0.8");

		BigDecimal x = a.subtract(b);
		BigDecimal y = b.subtract(c);
		System.out.println(a.add(b));// 1.9
		System.out.println(a.subtract(b));// 0.1
		System.out.println(a.multiply(b));// 0.90
		// 无法除尽，抛出 ArithmeticException 异常	System.out.println(a.divide(b));
		System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11

		System.out.println(x.compareTo(y));// 0
	}
}

