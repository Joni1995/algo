package BOJ_2468_안전영역;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, safetyZone, water;
	static int[][] map;
	static boolean[][] visited;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N: 지역의 크기, 2 이상 100 이하의 정수
		// water: 비의 양
		N = sc.nextInt();
		map = new int[N][N];

		water = 0;
		// map 지도 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // map 지도 입력 완

		// numMax = 지도 중 가장 높은 지역
		int numMax = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				numMax = Math.max(numMax, map[i][j]);
			}
		}
		// safetyZone : 안전 영역의 수
		safetyZone = 0;
		// 물이 1부터 최대 숫자가 될때까지 반복하여 그 중 안전 영역의 최대 값
		while (water <= numMax) {
			visited = new boolean[N][N];
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > water) {
						tmp++;
						BFS(i, j);
					}
				}
			}

			safetyZone = Math.max(safetyZone, tmp);
			water++; // 비의양++
		} // while문 끝
		System.out.println(safetyZone);
	} // class

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			int[] pos = q.poll();
			for (int i = 0; i < size; i++) {
				for (int d = 0; d < 4; d++) {
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] > water) {
						q.add(new int[] { nr, nc });
						visited[nr][nc] = true;

					}
				}

			}

		} // while문 끝

	} // BFS 메서드 끝

} // main
