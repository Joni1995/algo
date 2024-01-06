package BOJ_5014_스타트링크;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int f, s, g, u, d, ans;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// f: 건물의 층수, s :현재 위치 , g :목적지, u: 올라가는 층수, d: 내려가는 층수
		// (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000)
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();

		visited = new boolean[f + 1];
		ans = BFS();

		if (ans == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}

	} // main

	private static int BFS() {

		Queue<Integer> q = new LinkedList<>();
		// 가장 먼저 시작 위치 넣어주기
		q.add(s);
		visited[s] = true;
		// 카운트 횟수
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				// q에 넣어준 순서대로 빼기
				int current = q.poll();
				// 해당 숫자를 방문하지 않았다면
				// 만약 q에서 나온 숫자가 f(건물의 층수보다 크면 ans = -1 : 계단으로 이동)
				if (current == g) {
					return cnt;
				}

				int nextUp = current + u;
				int nextDown = current - d;

				if (nextUp <= f && !visited[nextUp]) {
					q.add(nextUp);
					visited[nextUp] = true;
				}
				if (nextDown >= 1 && !visited[nextDown]) {
					q.add(nextDown);
					visited[nextDown] = true;
				}

			}
			cnt++;
		} // while문 끝
		return -1;
	} // BFS 끝

} // class
