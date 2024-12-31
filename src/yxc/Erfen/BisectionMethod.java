package yxc.Erfen;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: shiyong
 * @CreateTime: 2024-10-04
 * @Description: 二分查找  数的范围
 * @Version: 1.0
 */


public class BisectionMethod {
	static final int N = 100010;
	static int[] a = new int[N];

	public static void main(String[] args){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = null;
		try {
			 s1 = in.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int q = Integer.parseInt(s1[1]);
			String[] s2 = in.readLine().split(" ");
			for(int i = 0; i < n; i ++){
				a[i] = Integer.parseInt(s2[i]);
			}
			while(q -- > 0){
				int k = Integer.parseInt(in.readLine());
				int l = 0, r = n - 1;
				while(l < r){
					int mid = l + r >> 1;
					if(a[mid] >= k){
						r = mid;
					}else{
						l = mid + 1;
					}
				}
				if(a[l] != k){
					System.out.println("-1 -1");
				}else{
					int left = l;
					l = 0;
					r = n - 1;
					while(l < r){
					  int mid = l + r + 1 >> 1;
					  if(a[mid] <= k){
					  	l = mid;
					  }else{
					  	r = mid - 1;
					  }
					  System.out.println(left + " " + l);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
