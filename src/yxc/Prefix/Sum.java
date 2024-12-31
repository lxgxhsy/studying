package yxc.Prefix;

import java.util.Scanner;

/**
 * @Author: shiyong
 * @CreateTime: 2024-10-07
 * @Description: 前缀和
 * @Version: 1.0
 * input:
 * 5 3
 * 2 1 3 6 4
 * 1 2
 * 1 3
 * 2 4
 *
 * output:
 * 3
 * 6
 * 10
 */


public class Sum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] a = new int[n + 1];
		int[] s = new int[n + 1];
		for (int i = 1; i <= n; i ++) {
			a[i] = scanner.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			s[i] = s[i - 1] + a[i];
		}
		while(m -- > 0){
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			System.out.println(s[r] - s[l - 1]);
		}
	}

}
