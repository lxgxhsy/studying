package yxc.Erfen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: sy
 * @CreateTime: 2024-10-04
 * @Description: 数的三次方根
 * @Version: 1.0
 */




public class CubeRoot {
	static double ESP = 1e-8;

	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double n = Double.parseDouble(in.readLine());

		double l = -1000;
		double r = 1000;
		while (r - l > ESP) {
			double mid = (l + r) / 2;
			if (mid * mid * mid < n) {
				l = mid;
			}else{
				r = mid;
			}
			System.out.printf("%.6f\n", l);
		}
	}
}
