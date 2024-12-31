package yxc.HighPrecision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: shiyong
 * @CreateTime: 2024-10-06
 * @Description: 高精度减法
 * @Version: 1.0
 * input:
 * 32
 * 11
 * output : 21
 */


public class Sub {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		for (int j = s1.length() - 1; j >= 0; j --) {
            A.add(s1.charAt(j) - '0');
		}
		for (int i = s2.length() - 1; i >= 0; i --) {
			B.add(s2.charAt(i) - '0');
		}
		if(!cmp(A,B)){
			System.out.print("-");
		}
		List<Integer> C = sub(A,B);
		for (int i = C.size() - 1; i >= 0 ; i --) {
			System.out.print(C.get(i));
		}
	}
	public static List<Integer> sub(List<Integer> A, List<Integer> B){
        if(!cmp(A,B)){
        	return sub(B,A);
        }

        List<Integer> C = new ArrayList<>();
        int t = 0;
		for (int i = 0; i < A.size(); i++) {
            /**
             *这里应该是A.get(i) - B.get(i) - t
             * 因为可能B为零，所以需要判断一下是不是存在
             */
			t = A.get(i) - t;
			if(i < B.size()){
				t -= B.get(i);
			}
			C.add((t + 10) % 10);

			if(t < 0){
				t = 1;
			}else{
				t = 0;
			}
		}
        while(C.size() > 1 && C.get(C.size() - 1) == 0){
        	C.remove(C.size() - 1);
        }

        return C;
	}

	public static boolean cmp(List<Integer> A, List<Integer> B){
		if(A.size() != B.size()){
			return A.size() > B.size();
		}
		for (int i = A.size() - 1; i >= 0; i --) {
          if(!A.get(i).equals(B.get(i))){
          	return A.get(i) > B.get(i);
          }
		}

		return true;
	}
}
