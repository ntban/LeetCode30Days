package april2020.week1;

import java.util.HashMap;

public class CountingElements {
	public int countElements(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int key : arr) {
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		int result = 0;
		for (Integer key : map.keySet()) {
			if (map.containsKey(key + 1)) {
				result += Math.min(map.get(key), map.get(key + 1));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = {1,1,2,2 };
		System.out.println(new CountingElements().countElements(arr));
	}
}
