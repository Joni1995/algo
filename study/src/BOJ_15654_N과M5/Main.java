package BOJ_15654_N과M5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] Narr;
	static int[] Marr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N개의 자연수
		M = sc.nextInt(); // 길이가 M인 수열

		Narr = new int[N]; // 입력받는 N개의 자연수를 가진 배열
		for (int i = 0; i < N; i++) {
			Narr[i] = sc.nextInt();
		}
		Marr = new int[M]; // 정답을 출력하는 배열
		visited = new boolean[N];

		swap(Narr);
		NM5(0);

	} // main

	public static void NM5(int idx) {
		// 기저 조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(Marr[i] + " ");
			}
			System.out.println();
		}
		// 재귀 조건
		else {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					Marr[idx] = Narr[i];
					NM5(idx + 1);
					visited[i] = false;
				}
			}

		}
	} // NM5 메서드 끝

	public static void swap(int[] arr) {

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (Narr[i] > Narr[j]) {
					int tmp = Narr[i];
					Narr[i] = Narr[j];
					Narr[j] = tmp;
				}
			}
		}

	} // swap 메서드 끝

} // class
