package BOJ_13397_구간나누기2;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열의 크기 N과 구간의 갯수 M이 주어진다. (1 ≤ N ≤ 5,000, 1 ≤ M ≤ N)
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		} // 데이터 입력 끝

		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;

		for (int i = 1; i < N; i++) {
			start = Math.min(start, nums[i]);
			end = Math.max(end, nums[i]);
		}

		System.out.println("start" + start); // 1
		System.out.println("end" + end); // 7

		while (start + 1 < end) {
			// 중간 지점
			int mid = (start + end) / 2; // 첫 mid : 4
			
			if (check(mid) <= M) {
				start = mid;
			} else {
				end = mid;
			}
		}

	} // main

	private static int check(int mid) {
		
		
		return 0;
	}

} // class