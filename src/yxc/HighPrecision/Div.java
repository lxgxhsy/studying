package yxc.HighPrecision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: shiyong
 * @CreateTime: 2024-10-06
 * @Description: 高精度除法
 * @Version: 1.0
 * input: 7 2
 * output: 3 1
 */


public class Div {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		int b = scanner.nextInt();
		List<Integer> A = new ArrayList<>(a.length());
		for(int i = a.length() - 1;i >= 0;i --) {
			A.add(a.charAt(i) - '0');
		}
		List<Integer> C = div(A,b);
		for(int i = C.size() - 2;i >= 0;i --) {
			System.out.print(C.get(i));
		}

		System.out.println();
		System.out.print(C.get(C.size() - 1));
	}
	public static List<Integer> div(List<Integer> A,int b){
		List<Integer> C = new ArrayList<>();

		int r = 0;
		for(int i = A.size() - 1 ;i >= 0; i --){
			r = r * 10 + A.get(i);
			C.add(r / b);
			r %= b;
		}
		Collections.reverse(C);
		while(C.size() > 1 && C.get(C.size() - 1) == 0) {
			C.remove(C.size() - 1);
		}
		C.add(r);
		return C;
	}
}
