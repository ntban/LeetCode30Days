package may2020.week1;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class FirstUniqueCharacter {
	public int firstUniqChar(String s) {
		int arr[] = new int[26];
		int index[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int pos = s.charAt(i) - 'a';
			if (arr[pos] == 0) {
				index[pos] = i;
			}
			arr[pos]++;
		}
		int minPos = s.length() + 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				minPos = Math.min(minPos, index[i]);
			}
		}
		if (minPos == s.length() + 1) {
			return -1;
		}
		return minPos;
	}

	public static void main1(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		FirstUniqueCharacter solution = new FirstUniqueCharacter();
		while (T-- > 0) {
			String s = sc.next();
			System.out.println(solution.firstUniqChar(s));
		}
		sc.close();
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 10);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		cal.add(Calendar.DATE, -13*8);
		System.out.println(dateFormat.format(cal.getTime()));
	}
}
