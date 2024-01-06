package BOJ_10773_제로;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // testCase 수
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			if (a != 0) {
				stack.push(a);
			} else {
				stack.pop();
			}
		
		}
		
		int sum = 0;
		while (stack.size() != 0) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	} // main 끝
} // class 끝
