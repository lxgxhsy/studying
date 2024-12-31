package yxc.Prefix;

import java.util.Scanner;

/**
 * @Author: shiyong
 * @CreateTime: 2024-10-07
 * @Description: 差分
 * 输入一个长度为 n 的整数序列 。
 * 接下来输入 m 个操作，每个操作包含三个整数 l,r,c ，
 * 表示将序列中 [l, r] 之间的每个数加上 c 。
 * 请你输出进行完所有操作后的序列。
 * @Version: 1.0
 *
 */


public class Differential {
	static int N = 1000010;
	static int[] a = new int[N];
	static int[] b = new int[N];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		for (int i = 1; i <= n; i ++) {
			a[i] = scanner.nextInt();
		}
		for (int i = 1; i <= n; i ++) {
			b[i] = a[i] - a[i - 1];
		}

		while(m -- > 0){

		}
	}
}
