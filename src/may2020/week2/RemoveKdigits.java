package may2020.week2;

public class RemoveKdigits {
	public String removeKdigits(String s, int k) {
		if(k >= s.length()) return "0";
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while (k > 0 && i < s.length() && s.charAt(i) <= s.charAt(i - 1)) {
			i++;
		}

		if (sb.length() == 0) {
			return "0";
		}
		return null;
	}
}
