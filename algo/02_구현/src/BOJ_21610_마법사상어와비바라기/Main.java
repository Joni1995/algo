package BOJ_21610_마법사상어와비바라기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, ans;
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] map;
	static Queue<int[]> q;
	static Queue<int[]> qCopy;

	// ↖, ↗, ↙, ↘
	static int[] drCopy = { -1, -1, 1, 1 };
	static int[] dcCopy = { -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N : 맵의 크기, M : 구름의 이동횟수
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // map 입력 끝

		q = new LinkedList<>();
		qCopy = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			// 방향 벡터는 0부터 시작
			int A = sc.nextInt() - 1;
			int B = sc.nextInt();

			q.add(new int[] { A, B });
		} // 구름의 이동방향과 크기 입력 끝

		// M번 이동만큼 반복
		for (int i = 0; i < M; i++) {
			// 첫번째 구름 생성 후 비까지 (구름의 크기 및 이동한만큼 +1)
			rain();
			// 물복사 버그 끝
			Copy();
			
			for (int j = 0; j < N; j++) {
				System.out.println(Arrays.toString(map[j]));
			}
			System.out.println(check());
			System.out.println();
		}

	} // main

	public static void rain() {

		int[][] cloud = new int[N][N];

		// pos[0] = 해당 구름의 방향, pos[1] = 해당 구름의 이동횟수
		int[] pos = q.poll();

		int nr = 0;
		int nc = 0;

		for (int i = N - 2; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				// 구름의 이동횟수만큼 반복
				nr = i + dr[pos[0]] * pos[1];
				nc = j + dc[pos[0]] * pos[1];
				if (nr < 0) {
					nr += N;
				}
				if (nr >= N) {
					nr -= N;
				}
				if (nc < 0) {
					nc += N;
				}
				if (nc >= N) {
					nc -= N;
				}
				qCopy.add(new int[] { nr, nc });
				cloud[nr][nc] += 1;

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += cloud[i][j];
			}
		}

		// 구름 확인
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(cloud[i]));
//		}

	} // rain 메서드 끝

	public static void Copy() {
		List<int[]> savePoint = new ArrayList<>();

		while (!qCopy.isEmpty()) {
			int[] pos = qCopy.poll();
			int r = pos[0];
			int c = pos[1];
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + drCopy[d];
				int nc = c + dcCopy[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 0) {
					cnt++;
				}
			} // 사방탐색 끝
			map[r][c] += cnt;
			savePoint.add(new int[] { r, c });

		} // while문 끝

		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < savePoint.size(); i++) {
			int[] pos = savePoint.get(i);
			visited[pos[0]][pos[1]] = true;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !visited[i][j]) {
					map[i][j] -= 2;
				}
			}
		}

	} // 4번 메서드

	public static int check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j];
			}
		}

		return ans;
	}

} // class
