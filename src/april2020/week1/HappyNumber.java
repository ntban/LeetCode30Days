package april2020.week1;

import java.util.HashSet;

public class HappyNumber {
	public boolean isHappy(int n) {
		HashSet<Integer> check = new HashSet<>();
		while (n > 1 && !check.contains(n)) {
			int sum = 0;
			check.add(n);
			int t = n;
			while (t > 0) {
				int d = t % 10;
				sum += d * d;
				t /= 10;
			}
			n = sum;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(4));
	}
}
