package BOJ_15650_N과M2;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 수열 중 가장 큰 수
		M = sc.nextInt(); // 출력될 때 수열의 갯수 (배열의 크기)
		arr = new int[M]; // 저장되는 수열의 배열

		C(0, 1);

	} // main

	public static void C(int cnt, int start) {
		// 기저 조건
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		// 재귀 조건
		else {
			for (int i = start; i <= N; i++) {
				arr[cnt] = i;
				C(cnt+1, i+1);
			}
		}

	} // C(조합) 끝

} // class
