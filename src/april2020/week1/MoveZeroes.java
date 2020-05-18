package april2020.week1;

import java.util.Arrays;

public class MoveZeroes {
	public void moveZeroes(int[] a) {
		int[] b = new int[a.length];
		int counter = 0;
		for (int element : a) {
			if (element != 0) {
				b[counter++] = element;
			}
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}
	
	public void moveZeroes2(int[] a) {
		int counter = 0;
		for (int element : a) {
			if (element != 0) {
				a[counter++] = element;
			}
		}
		for (int i = counter; i < a.length; i++) {
			a[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 3, 12 };
		new MoveZeroes().moveZeroes2(a);
		System.out.println(Arrays.toString(a));
	}
}
