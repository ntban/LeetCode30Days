package may2020.week2;

public class StraightLine {
	public boolean checkStraightLine(int[][] xy) {
		if (xy.length == 2)
			return true;
		double x1 = (double) xy[0][0], y1 = (double) xy[0][1];
		double x2 = (double) xy[1][0], y2 = (double) xy[1][1];
		double b = (y1 - y2) / (x1 - x2);
		double a = b * x1 - y1;
		for (int i = 2; i < xy.length; i++) {
			double x = (double) xy[i][0], y = (double) xy[i][1];
			if (x * b - y != a)
				return false;
		}

		return true;
	}
	
	public static void main(String[] args) {
		int xy[][]= {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
		System.out.println(new StraightLine().checkStraightLine(xy));
	}
}
