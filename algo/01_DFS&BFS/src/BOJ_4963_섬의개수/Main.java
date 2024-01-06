package BOJ_4963_섬의개수;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;
	// 방향 : 상 하 좌 우
	// 상 하 좌 우, 상좌, 상우, 하좌, 하우 대각선 (8방향)
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			// w: 지도의 너비, h : 지도의 높이
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];
			
			// map 지도 입력 ( 0 : sea, 1 : land)
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			} // map 지도 입력 끝
			cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// BFS 횟수만큼 섬의 개수를 확인할 수 있고
					// 해당 BFS 갯수는 전체 맵에서 방문하지 않아야하고 map이 땅으로 되어있는 경우만 해주면 된다.
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						BFS(i, j);
					}
				}
			}
			System.out.println(cnt);
		} // testCase 끝

	} // main

	public static void BFS(int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		q.offer(new int[] { r, c });
		
		while (!q.isEmpty()) {
			int size = q.size();
			int[] pos = q.poll();
			for (int i = 0; i < size; i++) {
				// 8 방향 탐색
				for (int d = 0; d < 8; d++) {
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];

					if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}

				} // 8 방향 탐색 끝
			}
		} // 반복문 끝
		
	} // BFS 메서드 끝
	
} // class
