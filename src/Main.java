import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

import may2020.week3.CheckInclusion;
import may2020.week3.FindAnagrams;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.next());
		CheckInclusion solution = new CheckInclusion();
		while (T-- > 0) {
			String p = scanner.next();
			String s = scanner.next();
			System.out.println(solution.checkInclusion(p, s));
		}
	}
}
