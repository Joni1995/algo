package BOJ_3022_개똥벌레;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//  (2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000), N은 항상 짝수
		N = sc.nextInt();
		H = sc.nextInt();
		
		int[] cave = new int[N];
		for (int i = 0; i < N; i++) {
			cave[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(cave));
	} // main
	
} // class
