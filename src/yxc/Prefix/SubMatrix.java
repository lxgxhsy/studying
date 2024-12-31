package yxc.Prefix;

import java.util.Scanner;

/**
 * @Author: sy
 * @CreateTime: 2024-10-07
 * @Description: 子矩阵的和
 * 输入一个 n
 *  行 m
 *  列的整数矩阵，再输入 q
 *  个询问，每个询问包含四个整数 x1,y1,x2,y2
 * ，表示一个子矩阵的左上角坐标和右下角坐标。
 *
 * 对于每个询问输出子矩阵中所有数的和。
 * @Version: 1.0
 *
 * input:
 * 3 4 3
 * 1 7 2 4
 * 3 6 2 8
 * 2 1 2 3
 * 1 1 2 2
 * 2 1 3 4
 * 1 3 3 4
 *
 * output:
 * 17
 * 27
 * 21
 */


public class SubMatrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int q = scanner.nextInt();
		int[][] a = new int[n + 1][m + 1];
		int[][] s = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= m; j ++) {
				a[i][j] = scanner.nextInt();
			}
		}
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= m; j ++) {
				s[i][j] = s[i - 1][j] + s[i][j - 1] -
						s[i - 1][j - 1] + a[i][j];
			}
		}
		while(q -- > 0){
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			System.out.println(s[x2][y2] - s[x1 - 1][y2]
					- s[x2][y1 - 1] + s[x1 - 1][y1 - 1]);
		}
	}
}
