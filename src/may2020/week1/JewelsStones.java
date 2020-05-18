package may2020.week1;

import java.util.HashSet;

public class JewelsStones {
	public int numJewelsInStones(String J, String S) {
		HashSet<Character> set = new HashSet<>();
		for(int i = 0; i < J.length(); i++) {
			set.add(J.charAt(i));
		}
		int count = 0;
		for(int i = 0; i < S.length(); i++) {
			if(set.contains(S.charAt(i))) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		String J = "z";
		String S = "aAAbbbb";
		System.out.println(new JewelsStones().numJewelsInStones(J, S));
	}
}
