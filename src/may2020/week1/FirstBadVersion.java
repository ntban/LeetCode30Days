package may2020.week1;

public class FirstBadVersion extends VersionControl {
	public FirstBadVersion(int n) {
		super(n);
	}

	int countTime;

	public int firstBadVersion(int n) {
		int result = -1;
		countTime = 0;
		long start = 1;
		long end = n;
		while (start <= end) {
			int mid = (int) ((start + end) / 2);
			countTime++;
			if (isBadVersion(mid)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	public int getCountTime() {
		return countTime;
	}

	public static void main(String[] args) {
		int n = 2126753390;

		FirstBadVersion solution = new FirstBadVersion(n);
		System.out.println(solution.getResult());
		System.out.println(solution.firstBadVersion(n));
		System.out.println(solution.getCountTime());
	}
}

class VersionControl {
	private int firstBad;

	public VersionControl(int n) {
		firstBad = 1702766719;
		// new Random().nextInt(n) + 1;
	}

	boolean isBadVersion(int version) {
		return version >= firstBad;
	}

	public int getResult() {
		return firstBad;
	}
}