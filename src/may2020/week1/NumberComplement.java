package may2020.week1;

public class NumberComplement {
	public int findComplement(int num) {
		int bits[] = new int[33];
		int count = 0;
		int n = num;
		while (n > 0) {
			bits[count++] = n % 2;
			n /= 2;
		}
		int p = 1;
		int result = 0;
		for (int i = 0; i < count; i++) {
			result += p * (1 - bits[i]);
			p *= 2;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = Integer.MAX_VALUE;
		System.out.println(new NumberComplement().findComplement(n));
	}
}
