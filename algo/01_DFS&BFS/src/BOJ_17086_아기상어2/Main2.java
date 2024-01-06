package BOJ_17086_아기상어2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	static int N, M, distance;
	static int[][] adjArr, shark;

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

		// 1 : 아기 상어가 있는 공간
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				shark[i][j] = sc.nextInt();
			}		
		} // shark 배열 입력 완료
		
		// 안전거리 초기화
		distance = 0;

		// *중요* 아기 상어가 있지 않는 모든 위치에서 BFS 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (shark[i][j] == 0) {
					BFS(i, j);
				}
			}
		}

		System.out.println(distance);
	} // main

	public static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		// 주어진 r,c를 방문하고
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		// tmp = 임시 안전거리
		int tmp = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				// pos[0] = r, pos[1] = c 새로운 좌표에 들어갈 r,c
				int[] pos = q.poll();
				// 8 방향 탐색
				for (int d = 0; d < 8; d++) {
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];

					// 해당 범위가 배열을 벗어나지 않는다면
					// q에 넣어주고 방문처리, 그리고 안전거리 +1
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
						// 그 위치에 상어가 있다면, 현재 tmp 값을 distance와 비교하여 더 큰 값을 distance에 저장하고 return
						if (shark[nr][nc] == 1) {
							distance = Math.max(distance, tmp);
							return;
						} else {
							// 그렇지 않다면 q에 넣어주고 방문처리
							q.offer(new int[] { nr, nc });
							visited[nr][nc] = true;
							
						}
					}
				} // 8방향 탐색 끝
			}
			tmp++; // 현재 레벨의 모든 칸을 탐색하면 안전 거리를 1 증가
		} // while문 끝
	} // BFS 끝

} // class
