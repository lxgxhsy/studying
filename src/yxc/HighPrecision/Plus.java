package yxc.HighPrecision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: shiyong
 * @CreateTime: 2024-10-04
 * @Description: 高精度加法
 * @Version: 1.0
 * input:
 * 32
 * 11
 * output:21
 */


public class Plus {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();
		//String表示长度用length这个方法,集合中用size这个方法
		List<Integer> A = new ArrayList<>(a.length());
		List<Integer> B = new ArrayList<>(b.length());
		for (int i = a.length() - 1; i >= 0; i --) {
             A.add(a.charAt(i) - '0');
		}
		for (int i = b.length() - 1; i >= 0; i --) {
			B.add(b.charAt(i) - '0');
		}

		List<Integer> C = add(A,B);
		for (int i = C.size() - 1; i >= 0 ; i --) {
			System.out.print(C.get(i) + "");
		}
	}
	public static List<Integer> add(List<Integer> A, List<Integer> B){
		List<Integer> C = new ArrayList<>();

		int t = 0;
		for (int i = 0; i < A.size() || i < B.size(); i++) {
			if(i < A.size()){
				t += A.get(i);
			}
			if(i < B.size()){
				t += B.get(i);
			}
			C.add(t % 10);
			t /= 10;
		}
        if(t != 0){
        	C.add(1);
        }
		return C;
	}
}
