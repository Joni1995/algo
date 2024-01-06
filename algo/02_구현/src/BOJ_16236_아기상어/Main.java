package BOJ_16236_아기상어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, time, placeR, placeC;
	static int[] eat;
	static int[][] map;
	// 방향 : 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N : 공간의 크기
		N = sc.nextInt();
		map = new int[N][N];
		eat = new int[3];
		// 물고기 크기 및 아기상어 위치 입력받기
		// 0: 빈 칸, 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기, 9: 아기 상어의 위치
		int startR = 0;
		int startC = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					startR = i;
					startC = j;
				}
			}
		} // map 입력 끝
			// time : 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
		time = 0;
		BFS(startR, startC, 2);
		System.out.println("time: " + time);
	} // main

	// 아기상어 탐색 범위
	private static void BFS(int r, int c, int size) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, size });

		// cnt : 물고기를 잡아먹은 횟수
		int cnt = 0;
		while (!q.isEmpty()) {
			// pos[0] : 아기상어의 r좌표, pos[1] : 아기상어의 c좌표, pos[2] : 아기상어의 크기
			int[] pos = q.poll();
			int distance = 0;
			// 먹이 찾는 메서드 (r,c,size 찾기)
			// placeR,C = 현재 아기 상어의 위치
			placeR = pos[0];
			placeC = pos[1];
			eatMin();

			for (int i = 0; i < 3; i++) {
				System.out.print(eat[i] + " ");
			}

			// 만약 상어의 크기가 먹이의 사이즈보다 크다면
			if (pos[2] > eat[2]) {
				// 거리는 두 좌표 각각 i 와 j의 차의 합
				distance = Math.abs(pos[0] - eat[0]) + Math.abs(pos[1] - eat[1]);
				// 물고기를 잡아먹은 횟수
				cnt++;
				// 초기 아기 상어의 위치는 0으로 변경해주고 잡아먹은 물고기의 위치는 9로 변경
				map[pos[0]][pos[1]] = 0;
				map[eat[0]][eat[1]] = 9;
				// 만약 상어가 잡아먹은 물고기의 수가 사이즈와 동일하다면
				if (size == cnt) {
					// 사이즈 증가하고 물고기 잡아먹은 횟수는 0으로 초기화
					size++;
					cnt = 0;
				}
				// q에 다시 바뀐 상어의 위치와 크기를 넣어준다.
				q.add(new int[] { eat[0], eat[1], size });
				// 시간은 해당 q가 계속 돌면서 생기는 거리의 합
				time += distance;
			}
			System.out.println("나 계속 돔");

			// 만약 상어의 크기가 먹이의 크기보다 작거나 같다면 (더 이상의 먹이가 없을 경우)
			if (pos[2] <= eat[2]) {
				break;
			}

		} // while 반복문 끝

	} // BFS 메서드 끝

	// 먹이를 찾는 메서드
	public static int[] eatMin() {
		// 먹이의 크기(min)와 위치(place = r*10 + c), distance = 먹이와 상어의 거리
		int min = 987654321;
		int place = 0;
		int distance = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 만약 먹이가 있다면
				// i,j는 현재 먹이의 좌표
				if (map[i][j] != 0 && map[i][j] != 9) {
					int tmp = Math.min(min, map[i][j]);
					// 해당 먹이가 기존 먹이보다 작다면 갱신
					if (min > tmp) {
						place = i * 10 + j;
						min = tmp;
						distance = Math.abs(placeR - i) + Math.abs(placeC - j);
						// 먹이의 크기가 같다면
					} else if (min == tmp) {
						// 거리 확인
						int tmpDistance = Math.abs(placeR - i) + Math.abs(placeC - j);
						// 현재 거리가 기존 거리보다 작다면
						if (distance < tmpDistance) {
							// 가까운 거리의 먹이로 place 위치 변경
							place = i * 10 + j;
						}
					}
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			// eat[0] : 먹이의 r위치, eat[1] : 먹이의 c위치, eat[2] : 가장 최소 먹이의 크기
			eat[0] = place / 10;
			eat[1] = place % 10;
			eat[2] = min;
		}

		return eat;
	} // 먹이를 찾는 메서드 끝

} // class
