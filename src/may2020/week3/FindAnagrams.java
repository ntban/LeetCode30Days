package may2020.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> indexes = new ArrayList<>();
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
				indexes.add(i + 1 - p.length());
		}
		return indexes;
	}
}
