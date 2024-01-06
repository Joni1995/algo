package BOJ_16234_인구이동;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> list;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N : 땅의 크기 (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
		// 각 나라의 인구수의 차이가 L <= 인구 수 차이 <= R 범위 안에 있으면 인구이동 발생
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];

		// 맵 정보 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // map 정보 입력 끝

		// bfsCnt = BFS 반복횟수
		int day = 0;
		while (true) {
			int bfsCnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[i][j] && !visited[nr][nc]
								&& Math.abs(map[nr][nc] - map[i][j]) >= L && Math.abs(map[nr][nc] - map[i][j]) <= R) {
							bfsCnt++;
							BFS(i, j);
							average();
							visited[i][j] = true;
							
						}

					} // 사방탐색 끝
					
				}
			} // i, j 탐색 끝


			if (bfsCnt == 0) {
				break;
			} // while문 종료를 위한 break 조건문
			day++;
		} // while문 끝

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		System.out.println(day);
	} // main

	// BFS 탐색
	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		list = new ArrayList<>();
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& Math.abs(map[nr][nc] - map[pos[0]][pos[1]]) >= L
						&& Math.abs(map[nr][nc] - map[pos[0]][pos[1]]) <= R) {
//					System.out.print("nr: " + nr + " ");
//					System.out.println("nc: " + nc);
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			} // 사방탐색 끝
			list.add(new int[] { pos[0], pos[1] });

		} // while문 끝

//		System.out.println("list size: " + list.size());

	} // BFS 끝

	// 평균으로 만드는 메서드
	public static void average() {
		int average = 0;

		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				int[] pos = list.get(i);
				int nr = pos[0];
				int nc = pos[1];
				average += map[nr][nc];
			}
			// size로 나눠주고
			average /= list.size();
//			System.out.println("average: " + average);
			for (int i = 0; i < list.size(); i++) {
				int[] pos = list.get(i);
				map[pos[0]][pos[1]] = average;
			}

		}
	}

} // class
