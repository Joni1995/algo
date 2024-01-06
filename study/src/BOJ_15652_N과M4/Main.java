package BOJ_15652_N과M4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];

		P(0, 1);

	} // class

	public static void P(int idx, int start) {
		// 기저조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");

			}
			System.out.println();
			return;
		}

		// 재귀 조건
		else {
			for (int i = start; i <= N; i++) {
				arr[idx] = i;
				P(idx + 1, i);

			}

		}

	} // P method 끝

}
