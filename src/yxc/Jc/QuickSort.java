package yxc.Jc;
import java.util.*;

/**
 * @Author: sy
 * @CreateTime: 2024-09-12
 * @Description: 快速排序
 * @Version: 1.0
 */


public class QuickSort {
	public static void main(String[] args) {
	Scanner rc = new Scanner(System.in);
	int n = rc.nextInt();
	int[] q = new int[n];
		for (int i = 0; i < n; i++) {
			q[i] = rc.nextInt();
		}
		quickSort(q, 0, n-1);
	
		for(int i=0; i<n; i++){
			System.out.print(q[i] + " ");
		}
	}


	public static void quickSort(int[] q, int l ,int r){
		if(l >= r) {
			return;
		}
		int x = q[l + r >> 1], i = l - 1, j = r + 1;
		while(i < j){
			while(q[++ i] < x) {
				;
			}
			while(q[-- j] > x) {
				;
			}
			if(i < j){
				int t = q[i];
				q[i] = q[j];
				q[j] = t;
			}
		}
		quickSort(q,l,j);
		quickSort(q,j + 1, r);

	}
}
