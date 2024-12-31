package yxc.Jc;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author: sy
 * @CreateTime: 2024-10-04
 * @Description: 归并求逆序对
 * @Version: 1.0
 *
 * 6
 * 2 3 4 5 6 1
 * 5
 */


public class InversePair {
	public static void main(String[] args){
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		System.out.println(mergeSort(a, 0, n - 1));
		scanner.close();
	}

	public static long mergeSort(int[] a, int l, int r) {
		if(l >= r){
			return 0;
		}
		int mid = l + r >> 1;
		long res = mergeSort(a, l, mid) + mergeSort(a, mid + 1, r);
		int tmp[] = new int[r - l + 1];
		int k = 0, i = l, j = mid + 1;
		while(i <= mid && j <= r){
			if(a[i] <= a[j]){
				tmp[k ++] = a[i ++];
			}else{
				res += mid - i + 1;
				tmp[k ++] = a[j ++];
			}
		}
		while(i <= mid){
			tmp[k ++] = a[i ++];
		}
		while(j <= r){
			tmp[k ++] = a[j ++];
		}
		for (i = l, j = 0; i <= r; i++,j ++) {
			a[i] = tmp[j];
		}
		return res;
	}
}
