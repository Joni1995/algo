package BOJ_15649_N과M1;

import java.util.Scanner;

public class Main {
	static int N; // 수열의 최대 크기
	static int M; // 수열의 개수
	static int[] arr; // 뽑은 숫자를 저장할 배열
	static boolean[] visited; // 중복을 제거하기 위한 방문 처리를 체크하는 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N+1];
		P(0);
	}

	private static void P(int cnt) {
		// 기저 조건
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		// 재귀 조건
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				P(cnt+1);
				visited[i] = false;
			}
			
		}
		
	}
	
} // class
