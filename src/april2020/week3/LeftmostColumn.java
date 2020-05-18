package april2020.week3;

import java.util.ArrayList;
import java.util.List;

public class LeftmostColumn {
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int n = dimensions.get(0);
		int m = dimensions.get(1);

		int ans = n;
		for (int row = 0; row < n; row++) {
			int bs = binSrch(0, m - 1, row, binaryMatrix);
			if (bs != -1 && bs < ans) {
				ans = bs;
			}
		}
		if(ans == n)return -1;
		return ans;
	}

	int binSrch(int start, int end, int row, BinaryMatrix binaryMatrix) {
		int ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (binaryMatrix.get(row, mid) == 1) {
				end = mid - 1;
				ans = mid;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int a[][] = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 } };
		BinaryMatrix bm = new BinaryMatrix(a);
		LeftmostColumn sol = new LeftmostColumn();
		System.out.println(sol.leftMostColumnWithOne(bm));
	}
}

class BinaryMatrix {
	int a[][];

	public BinaryMatrix(int[][] a) {
		this.a = a;
	}

	public int get(int x, int y) {
		return a[x][y];
	}

	public List<Integer> dimensions() {
		List<Integer> d = new ArrayList<>();
		d.add(a.length);
		d.add(a[0].length);
		return d;
	}
};
