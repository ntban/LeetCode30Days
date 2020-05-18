package may2020.week2;

public class FindSqrt {
	public boolean isPerfectSquare(int num) {
		int start = 1;
		int end = num;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			long p = (long)mid * mid;
			if (p == num) {
				//System.out.println(mid);
				return true;
			}
			if (p > num ) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//2147395600
		//2147483647
		System.out.println(new FindSqrt().isPerfectSquare(2147395600));

	}

}
