package BOJ_15651_N과M3;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int N, M;
	static int[] answer, nums;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		answer = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		P(0);

	}

	static void P(int idx) {
		// 기저조건
		if (idx == M) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			// 재귀조건
		} else {
			for (int i = 0; i < N; i++) {
//				if(!visited[i]) {
//					visited[i] = true;
					answer[idx] = nums[i];
					P(idx + 1);
//					visited[i] = false;
//				}

			}

		}
	}

}
