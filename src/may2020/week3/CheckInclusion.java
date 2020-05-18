package may2020.week3;

import java.util.HashMap;

public class CheckInclusion {
	public boolean checkInclusion(String p, String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			Character c = p.charAt(i);
			if (!map.containsKey(c))
				map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}
		HashMap<Character, Integer> compareMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (!compareMap.containsKey(c))
				compareMap.put(c, 0);
			compareMap.put(c, compareMap.get(c) + 1);
			if (i >= p.length()) {
				Character k = s.charAt(i - p.length());
				if (compareMap.get(k) == 1)
					compareMap.remove(k);
				else
					compareMap.put(k, compareMap.get(k) - 1);
			}
			if (compareMap.equals(map))
				return true;
		}
		return false;
	}

}
