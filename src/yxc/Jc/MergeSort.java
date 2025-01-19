package yxc.Jc;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author: sy
 * @CreateTime: 2025-01-19
 * @Description: 归并排序
 * @Version: 1.0
 */


public class MergeSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		mergeSort(a, 0, n - 1);

		for(int i=0; i<n; i++){
			System.out.print(a[i] + " ");
		}
		scanner.close();
	}


	public static void mergeSort(int[] a, int l, int r) {
		if(l >= r) {
			return ;
		}
		int mid = l + r >> 1;
		int tmp[] = new int[r - l + 1];
		int k = 0, i = l, j = mid + 1;
		while(i <= mid && j <= r){
			if(a[i] <= a[j]){
				tmp[k ++] = a[i ++];
			}else{
				tmp[k ++] = a[j ++];
			}
		}

		while(i <= mid) {
			tmp[k ++] = a[i ++];//把剩下的加上
		}
		while(j <= r) {
			tmp[k ++] = a[j ++];
		}

		for(i = l, j = 0; i <= r; i ++, j ++) {
			a[i] = tmp[j];//把存在tmp的结果复制到q里面
		}
	}
}
