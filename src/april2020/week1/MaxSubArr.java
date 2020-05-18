package april2020.week1;

public class MaxSubArr {
	public int maxSubArray(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			max = Math.max(max, a[i]);
			int sum = a[i];
			for (int j = i + 1; j < a.length; j++) {
				sum += a[j];
				max = Math.max(max, sum);
			}
		}
		return max;
	}

	public int maxSubArray2(int[] a) {
		if (a.length == 0)
			return -1;
		int answer = a[0];
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			max = Math.max(max + a[i], a[i]);
			answer = Math.max(max, answer);
		}
		return answer;
	}

	public static void main(String[] args) {
		int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(new MaxSubArr().maxSubArray2(a));
	}
}
