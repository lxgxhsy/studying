package yxc.Jc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: sy
 * @CreateTime: 2024-09-13
 * @Description: 第k大的数字
 * @Version: 1.0
 */


public class RankKnum {
	public static void main(String[] args) {
		Scanner sy = new Scanner(System.in);
		int n = sy.nextInt();
		int k = sy.nextInt();
		int[] q = new int[n];
		for (int i = 0; i < n; i++) {
			q[i] = sy.nextInt();
		}
//		Arrays.sort(q);
		quickSort(q, 0, n - 1);
		System.out.println(q[k - 1]);
	}

	public static void quickSort(int[] q, int l, int r) {

		if (l >= r) {
			return;
		}
		int x = q[(r - l) / 2 + l];
		int i = l - 1, j = r + 1;
		while (i < j) {
			while (q[++i] < x) {
				;
			}
			while (q[--j] > x) {
				;
			}
			if (i > j) {
				int temp = q[i];
				q[i] = q[j];
				q[j] = temp;
			}
		}
		quickSort(q, l, j);
		quickSort(q, j + 1, r);
	}

	/**
	 * 归并排序
	 *
	 * @param q
	 * @param l
	 * @param r
	 */
	public static void mergeSort(int[] q, int l, int r) {
		int[] temp = new int[q.length];
		if (l >= r) {
			return;
		}
		int mid = l + r >> 1;
		mergeSort(q, l, mid);
		mergeSort(q, mid + 1, r);
		int k = 0, i = l, j = mid + 1;
		while (i <= mid && j <= r) {
			if (q[i] <= q[j]) {
				temp[k ++] = q[i ++];
			} else {
				temp[k ++] = q[j ++];
			}
		}
		while (i <= mid) {
			temp[k++] = q[i++];
		}
		while (j <= r) {
			temp[k++] = q[j++];
		}
		for (int t = 0; t < q.length; t ++) {
			q[t] = temp[t];
		}
	}
}
