package april2020.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	private HashMap<Character, Integer> hashedOne(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, 1 + map.get(c));
			}
		}
		return map;
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		HashMap<HashMap<Character, Integer>, List<String>> mapList = new HashMap<>();
		for (String s : strs) {
			HashMap<Character, Integer> key = hashedOne(s);
			if (!mapList.containsKey(key)) {
				List<String> list = new ArrayList<>();
				list.add(s);
				mapList.put(key, list);
			} else {
				mapList.get(key).add(s);
			}
		}
		List<List<String>> groups = new ArrayList<List<String>>();
		for (HashMap<Character, Integer> key : mapList.keySet()) {
			groups.add(mapList.get(key));
		}

		return groups;
	}

	public static void main(String[] args) {
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> groups = new GroupAnagrams().groupAnagrams(strs);
		for (List<String> group : groups) {
			for (String s : group)
				System.out.print(s + " ");
			System.out.println();
		}
	}
}
