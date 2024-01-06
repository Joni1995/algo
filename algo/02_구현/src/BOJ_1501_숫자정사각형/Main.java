package BOJ_1501_숫자정사각형;

import java.util.Scanner;

public class Main {
	// 자기자신, 우측, 아래측, 대각선 우측 아래
	static int[] dr = {0, 1, 0, 1 };
	static int[] dc = {0, 0, 1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];

		int size = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int num = map[i][j];
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && num == map[nr][nc]) {
						cnt++;
						System.out.println("cnt: " + cnt);
						if (cnt == 4) {
							size++;
						}
					}
					
				}
				
			}
		}

		System.out.println(size * size);

	} // main
} // class
