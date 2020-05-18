package may2020.week2;

import java.io.FileInputStream;
import java.util.Scanner;

public class SingleNonDuplicate {
	public int singleNonDuplicate(int[] a) {
		if (a.length == 1) return a[0];
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int check = check(mid, a);
			if (check == 0) return a[mid];
			if (check == -1) {
				int before = mid - 1 - start;
				if (before % 2 == 1) end = mid - 2;
				else start = mid + 1;
			} else {
				int before = mid - start;
				if (before % 2 == 1) end = mid - 1;
				else start = mid + 2;
			}
		}
		return -1;
	}

	private int check(int mid, int[] a) {
		if (mid == a.length - 1) {
			if (a[mid] != a[mid - 1]) return 0;
			return -1;
		}
		if (mid == 0) {
			if (a[mid] != a[mid + 1]) return 0;
			return 1;
		}
		if (mid - 1 >= 0 && mid + 1 <= a.length - 1) {
			if (a[mid] != a[mid + 1] && a[mid] != a[mid - 1]) return 0;
			if (a[mid] == a[mid + 1]) return 1;
			if (a[mid] == a[mid - 1]) return -1;
		}
		return -2;
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		SingleNonDuplicate solution = new SingleNonDuplicate();
		while (T-- > 0) {
			int N = scanner.nextInt();
			int a[] = new int[N];
			for(int i = 0; i < N; i++) a[i] = scanner.nextInt();
			System.out.println(solution.singleNonDuplicate(a));
		}
		scanner.close();
		
	}
}
