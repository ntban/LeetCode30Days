package may2020.week2;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class FloodFill {
	int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		boolean check[][] = new boolean[image.length][];
		for (int i = 0; i < image.length; i++) {
			check[i] = new boolean[image[i].length];
		}
		int oldColor = image[sr][sc];
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(sr, sc));
		check[sr][sc] = true;
		image[sr][sc] = newColor;
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int r = point.r + dir[i][0];
				int c = point.c + dir[i][1];
				if (r >= 0 && r < image.length && c >= 0 && c < image[r].length 
						&& image[r][c] == oldColor && !check[r][c]) {
					queue.add(new Point(r, c));
					check[r][c] = true;
					image[r][c] = newColor;
				}
			}
		}
		return image;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		FloodFill solution = new FloodFill();
		while (T-- > 0) {
			int sr = scanner.nextInt();
			int sc = scanner.nextInt();
			int newColor = scanner.nextInt();
			int R = scanner.nextInt();
			int image[][] = new int[R][];

			for (int i = 0; i < image.length; i++) {
				int C = scanner.nextInt();
				image[i] = new int[C];
				for (int j = 0; j < image[i].length; j++) {
					image[i][j] = scanner.nextInt();
				}
			}
			int result[][] = solution.floodFill(image, sr, sc, newColor);
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[i].length; j++) {
					System.out.printf("%d ", result[i][j]);
				}
				System.out.println();
			}
			System.out.println("------------------------");
		}
		scanner.close();
	}

}
