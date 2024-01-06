package SWEA_4615_재미있는오셀로게임;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // Test Case
		
		for (int t = 1; t <= T; t++) { // Test Case
			int N = sc.nextInt(); // 보드의 한 변의 길이
			int M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수
			
			int[][] board = new int[N][N]; // 보드판 배열
			
			// 방향 :	상 하 좌 우 
			int[] dr = {-1, 1, 0 ,0};
			int[] dc = {0, 0, -1, 1};
			
			// 흑돌(B): 1 , 백돌(W): 2
			// 배열은 0,0부터 시작하는데 주어지는 입력값은 1,1부터 시작한다!!
			for (int i = N/2-1; i <= N/2; i++) { // 중앙에 2개의 흑돌, 백돌 위치 정해주기
				for (int j = N/2-1; j <= N/2; j++) {
					if (i == j) {
						board[i][j] = 2;
					} else {
						board[i][j] = 1;
					}
				}
				
			} // 중앙 흑돌, 백돌 배치 반복문 끝
			
			// 중앙 흑돌, 백돌 배치 잘 되어있는지 확인
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(board[i][j]);
//				}
//				System.out.println();
//			}
			
			int cnt = 0;
			// 반복횟수
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int stone = sc.nextInt(); // 흑돌(1), 백돌(2)
				board[x-1][y-1] = stone;
				
				
				
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			
//			while(cnt < M) {
//				// 입력을 3개씩 받는데 이차원 배열에 어떻게 넣어야할까?
//				
//				
//				
//				cnt++;
//			}
			
			
			
			
		} // Test Case 끝
		
		
		
	} // main 끝
	
	
} // class 끝
