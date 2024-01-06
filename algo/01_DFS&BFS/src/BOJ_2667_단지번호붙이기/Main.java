package BOJ_2667_단지번호붙이기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, vilage;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> list;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N: 지도의 크기 (5≤N≤25), vilage : 마을 단지의 수
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		vilage = 0;
		list = new ArrayList<>();

		// 지도 입력받기 (1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다)
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		} // 지도 입력 끝

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문처리 안되어있고 map이 1인 경우(집이 있는 경우)에만 BFS 실행
				if (!visited[i][j] && map[i][j] == 1) {
					// BFS 실행되는 횟수 = vilage 마을 단지의 수
					vilage++;
					BFS(i, j);
				}
			}
		}
		
		// 출력
		System.out.println(vilage);
		// list 정렬해주기
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	} // main

	public static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		int house = 0; // 마을의 개수
		while (!q.isEmpty()) {
			int size = q.size();
			int[] pos = q.poll();
			for (int i = 0; i < size; i++) {

				for (int d = 0; d < 4; d++) {
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];
					// 집이 있는 1인 경우에 대해서만 q에 새로운 좌표를 넣어주면서 반복 
					if(nr >= 0 && nr < N && nc >=0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
						q.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
					
				} // 4방향 탐색 끝
				
			}
			// q에 들어갔다가 나온 갯수만큼 반복문이 돌아갈 것이므로 집 갯수를 세줌
			house++;
		} // while문 끝
		list.add(house);
	} // 메서드 끝

} // class
