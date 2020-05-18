package may2020.week1;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> magazineMap = countCharacter(magazine);
		HashMap<Character, Integer> noteMap = countCharacter(ransomNote);
		for (Character key : noteMap.keySet()) {
			if (!magazineMap.containsKey(key)) {
				return false;
			}
			if (magazineMap.get(key) < noteMap.get(key)) {
				return false;
			}
		}
		return true;
	}

	private HashMap<Character, Integer> countCharacter(String string) {
		HashMap<Character, Integer> countMap = new HashMap<>();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (!countMap.containsKey(c)) {
				countMap.put(c, 0);
			}
			countMap.put(c, countMap.get(c) + 1);
		}
		return countMap;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		RansomNote solution = new RansomNote();
		while (T-- > 0) {
			String ransomNote = sc.next();
			String magazine = sc.next();
			System.out.println(solution.canConstruct(ransomNote, magazine));
		}
		sc.close();
	}
}
