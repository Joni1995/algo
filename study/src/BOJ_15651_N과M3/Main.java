package BOJ_15651_N과M3;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		sb = new StringBuilder();

		repeatP(0);
		System.out.println(sb.toString());

	} // main

	public static void repeatP(int idx) {
		// 기저 조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀조건
		else {
			for (int i = 1; i <= N; i++) {
					arr[idx] = i;
					repeatP(idx + 1);

			}
		}

	}

} // class
