package yxc.HighPrecision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: sy
 * @CreateTime: 2024-10-06
 * @Description: 高精度乘法
 * @Version: 1.0
 * input: 2 3
 * output: 6
 */


public class Mul {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		int b = scanner.nextInt();
		List<Integer> A = new ArrayList<>(a.length());
		for (int i = a.length() - 1; i >= 0; i --) {
            A.add(a.charAt(i) - '0');
		}
		List<Integer> C = mul(A, b);
		for (int i = C.size() - 1; i >= 0; i --) {
			System.out.print(C.get(i));
		}
	}

	public static List<Integer> mul(List<Integer> A, int b){
		List<Integer> C = new ArrayList<>();
        int t = 0;
		for (int i = 0; i < A.size() || t != 0; i++) {
			if(i < A.size()){
				t += A.get(i) * b;
			}
			C.add(t % 10);
			t /= 10;
		}
        while(C.size() > 1 && C.get(C.size() - 1) == 0){
        	C.remove(C.size() - 1);
        }
		return C;
	}

}
