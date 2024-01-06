package BOJ_17086_아기상어2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, distance;
	static int[][] adjArr, shark;
	static boolean[][] visited;
	// 상 하 좌 우, 상좌, 상우, 하좌, 하우 대각선 (8방향)
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N, M : 공간의 크기 (2 ≤ N, M ≤ 50)
		N = sc.nextInt();
		M = sc.nextInt();
		// shark : 아기 상어가 있는 공간
		shark = new int[N][M];
		visited = new boolean[N][M];

		// 1 : 아기 상어가 있는 공간
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				shark[i][j] = sc.nextInt();
			}
		} // shark 배열 입력 완료

		// DFS 메서드 실행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				DFS(i, j);
			}
		}

	} // main

	public static void DFS(int r, int c) {
		// 기저 조건
		if (shark[r][c] == 1) {
			System.out.println(distance);
			return;
		}
		// 재귀 조건

		// tmp : 임시 안전거리
		int tmp = 0;
		// 8방향 탐색
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 다음 위치의 배열이 범위를 벗어나지 않고 방문하지 않았다면
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && shark[nr][nc] != 1) {
				distance = Math.max(distance, tmp);
				// 해당 위치 방문처리
				visited[nr][nc] = true;
				// 임시 거리값 +1
				if (shark[nr][nc] == 0) {
					tmp++;
				}
				// distance 값 중 max로 갱신 (안전거리 큰 값)
				distance = Math.max(distance, tmp);
				// DFS 재귀
				DFS(nr, nc);
//				System.out.println("nr: " + nr + " " + "nc: " + nc);
				visited[nr][nc] = false;

			}

		}

	} // DFS 끝

} // class
