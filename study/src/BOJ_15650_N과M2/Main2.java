package BOJ_15650_N과M2;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int N, M;
	static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		answer = new int[M];

		P(0, 1);

	}

	static void P(int idx, int start) {
		// 기저조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
			// 재귀조건
		} else {
			for (int i = start; i <= N; i++) {
					answer[idx] = i;
					P(idx+1, i+1);

			}

		}
	}

}