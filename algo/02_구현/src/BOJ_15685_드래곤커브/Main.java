package BOJ_15685_드래곤커브;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map = new int[101][101];
	// dir = 0 (우), 1 (상), 2(좌), 3(하)
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N : 드래곤 커브의 갯수
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			// (0 ≤ r, c ≤ 100, 0 ≤ d ≤ 3, 0 ≤ g ≤ 10)
			// r,c : 드래곤 커브의 시작 좌표, d : 시작 방향, depth : 세대
			int c = sc.nextInt();
			int r = sc.nextInt();
			int dir = sc.nextInt();
			int depth = sc.nextInt();

			// 방향 변경하는 순서를 담은 배열
			int[] dragonCurve = new int[(int) Math.pow(2, depth)];
			// 첫 방향은 입력값
			dragonCurve[0] = dir;
			// 깊이만큼 반복하고, 그다음 last의 첫번째 값에 +1을 해주고 %4를 한 값을 추가
			for (int j = 1; j <= depth; j++) {
				for (int k = (int) Math.pow(2, j - 1) - 1, idx = (int) Math.pow(2, j - 1); k >= 0; k--) {
					dragonCurve[idx++] = (dragonCurve[k] + 1) % 4;
				}
			}
//			System.out.println(Arrays.toString(dragonCurve));

			// 첫 좌표는 방문하는 것이므로 1로 갱신
			map[r][c] = 1;
			// 다음 방문하는 좌표들에 대해서 1로 갱신
			for (int j = 0; j < dragonCurve.length; j++) {
				r += dr[dragonCurve[j]];
				c += dc[dragonCurve[j]];
				map[r][c] = 1;
			}
		} // dragonCurve 반복 끝

		// 갯수 세는 변수
		cnt = 0;
		// 1x1사각형 4개의 좌표에 1이 있는지 검사
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	} // main
} // class
