package BOJ_2644_촌수계산;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m, a, b, x, y, answer;
	static int[][] adjArr;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// n : 전체 사람 의 수(1 ≤ n ≤ 100)
		n = sc.nextInt();
		// a, b : 촌수를 계산해야 하는 서로 다른 두 사람의 번호
		a = sc.nextInt();
		b = sc.nextInt();
		// m : 부모 자식들 간의 관계의 개수
		m = sc.nextInt();
		adjArr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= m; i++) {
			// x : y의 부모 번호 (y: 자식 번호)
			x = sc.nextInt();
			y = sc.nextInt();
			// 부모 자식관의 관계 연결성
			adjArr[x][y] = 1;
			adjArr[y][x] = 1;

		}

		answer = -1;
		DFS(a, 0);

		System.out.println(answer);
	} // main

	// DFS 재귀 이용
	public static void DFS(int v, int depth) {
		visited[v] = true;
		// 기저 조건
		if (v == b) {
			answer = depth;
			return;
		}

		// 인접노드 탐색
		// 재귀 조건
		for (int i = 1; i <= n; i++) {
			if (adjArr[v][i] == 1 && !visited[i]) {
				DFS(i, depth + 1);
			}
		}

	} // DFS 메서드 끝

} // class
