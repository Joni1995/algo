package BOJ_15649_N과M1;

import java.util.Arrays;
import java.util.List;

public class Combination1 {

	static char[] src = { 'a', 'b', 'c', 'd' };

	/*
	 * 기본 조합: 중복 X, 순서 X
	 * 
	 * @param nth - 몇 번째 선택인지 표현
	 * 
	 * @param choosed - 선택된 요소
	 * 
	 * @param startIdx - 몇 번째 요소부터 반복하며 선택할 것인지 표현
	 */
	static void makeCombination(int nth, char[] choosed, int startIdx) {
		if (nth == choosed.length) { // 기저 조건: choosed를 다 채웠다면 끝
			System.out.println(Arrays.toString(choosed));
			return;
		}

		for (int i = startIdx; i < src.length; i++) {
			choosed[nth] = src[i];
			makeCombination(nth + 1, choosed, i + 1); // 중복 방지를 위한 장치: i+1
		}
	}

	public static void main(String[] args) {
//		System.out.println("조합");
//		makeCombination(0, new char[3], 0); // src에서 3개를 뽑아 만들 수 있는 조합을 모두 출력
	}

	private static void reculsion(List<String> arr, List<String> result, int index, int n, int r) {

		if (r == 0) {

			System.out.println(result.toString());
			return;
		}

		for (int i = index; i < n; i++) {

			result.add(arr.get(i));
			reculsion(arr, result, i + 1, n, r - 1);
			result.remove(result.size() - 1);
		}
	}

}