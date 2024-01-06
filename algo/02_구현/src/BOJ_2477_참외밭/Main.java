package BOJ_2477_참외밭;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// K : 참외의 개수
		int K = sc.nextInt();
		int[][] fruit = new int[6][2];
		
		for (int i = 0; i < 6; i++) {
			fruit[i][0] = sc.nextInt();
			fruit[i][1] = sc.nextInt();
			
		} // tc 6개
		
		int rowLength = 0;
		int colLength = 0;
		
		int rowPlace = 0;
		int colPlace = 0;
		
		for (int i = 0; i < 6; i++) {
			// 방향이 좌(2) 또는 우(1)일 때
			if (fruit[i][0] == 1 || fruit[i][0] == 2) {
				if (fruit[i][1] > rowLength) {
					rowLength = Math.max(rowLength, fruit[i][1]);
					rowPlace = i;
				}
			} else {
				if (fruit[i][1] > colLength) {
					colLength = Math.max(colLength, fruit[i][1]);
					colPlace = i;
				}
			}
		}
		
		int square = rowLength * colLength;
		
//		for (int i = 0; i < 6; i++) {
//			if (fruit[i][1] == rowLength) {
//				rowPlace = i;
//			} else if (fruit[i][1] == colLength) {
//				colPlace = i;
//			}
//		}
		
		int smallCol = 0;
		int smallRow = 0;
		
		if (rowPlace == 0) {
			smallCol = Math.abs(fruit[1][1] - fruit[5][1]);
		} else if (rowPlace == 5) {
			smallCol = Math.abs(fruit[4][1] - fruit[0][1]);
		} else {
			smallCol = Math.abs(fruit[rowPlace-1][1] - fruit[rowPlace+1][1]);
		}
		
		if (colPlace == 0) {
			smallRow = Math.abs(fruit[1][1] - fruit[5][1]);
		} else if (colPlace == 5) {
			smallRow = Math.abs(fruit[4][1] - fruit[0][1]);
		} else {
			smallRow = Math.abs(fruit[colPlace-1][1] - fruit[colPlace+1][1]);
		}
		
		int minus = smallCol * smallRow;
		
		int answer = (square - minus) * K;
		
		System.out.println(answer);
		
	} // main
} // class
