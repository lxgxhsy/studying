package Jichu.Test.Gather.Collection.List;

import java.util.Arrays;

/**
 * @Author: shiyong
 * @CreateTime: 2025-02-27
 * @Description: 测试一下语法糖
 * @Version: 1.0
 */


public class TestDemo {
	public static void main(String[] args) {
		String[] str = new String[]{"hello","lxg","!"};
		// 修改String的值
		str[0] = "goodBye";
		System.out.println(Arrays.toString(str));// [goodbye, lxg, !]
		// 删除数组中的元素，需要手动移动后面的元素
		for (int i = 0; i < str.length - 1; i++) {
			str[i] = str[i + 1];
		}
		str[str.length - 1] = null;
		System.out.println(Arrays.toString(str));// [lxg, !, null]

	}
}
