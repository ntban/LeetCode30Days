package april2020.week3;

public class SrchRotSortArr {

	public int search(int[] a, int target) {
		if (a.length == 0)
			return -1;
		int rotatedIndex = findPivot(0, a.length - 1, a, a[0]);
		int index = binSrch(0, rotatedIndex, a, target);
		if (index != -1)
			return index;
		return binSrch(rotatedIndex + 1, a.length - 1, a, target);
	}

	int binSrch(int start, int end, int[] a, int target) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] < target) {
				start = mid + 1;
			} else if (a[mid] > target) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	int findPivot(int start, int end, int[] a, int target) {
		int ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] >= target) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 4, 5, 6, 7 };
		System.out.println(new SrchRotSortArr().search(a, 4));
	}
}
