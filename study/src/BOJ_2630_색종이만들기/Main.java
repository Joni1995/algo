package BOJ_2630_색종이만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt(); // N = 전체 종이의 한 변의 길이
		int[][] paper = new int[N][N]; // 전체 종이의 배열(N*N)

		// 데이터 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		} // paper 배열에 데이터 입력받기 완료

//		 // 입력 확인
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(paper[i]));
//		}

	} // main

	// 색종이 분할하는 메서드
	static void cut(int[][] arr, int n) {
		// 기저 조건 : 더 이상 나눌 수 있는 경우의 수가 없을 경우
		if (n == 1) {

		}

		// 재귀 조건

	}

	// 해당 색종이의 크기 전체를 탐색하여 전부 0인지, 1인지 구분하는 메서드 (흰색=0, 파랑 = 1)
	static void color(int[][] arr, int white, int blue) {
		int n = arr.length;
		int numBlue = 0; // 파란색 갯수를 판단하는 변수
		int numWhite = 0; // 하얀색 갯수를 판단하는 변수

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) { // 해당 좌표가 0이면
					numWhite++; // 하얀색 갯수 +1
				} else { // 해당 좌표가 0이 아니면 (1이면)
					numBlue++; // 파란색 갯수 +1
				}
			}
		} // 반복문 끝

		// 만약 흰색이 전부 0으로 채워져있다면 (전체 면 갯수 = n*n개)
		if (numWhite == n * n && numBlue == 0) {
			white += 1;
		} else if (numBlue == n * n && numWhite == 0) {
			blue += 1;
		}

	}

} // class
