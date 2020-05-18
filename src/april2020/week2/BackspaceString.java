package april2020.week2;

import java.util.Stack;

public class BackspaceString {
	public boolean backspaceCompare(String S, String T) {
		Stack<Character> sStack = deleteString(S);
		Stack<Character> tStack = deleteString(T);
		return sStack.equals(tStack);
	}

	private Stack<Character> deleteString(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '#') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(c);
			}
		}
		return stack;
	}

	public static void main(String[] args) {
		String S = "ab#c";
		String T = "cd#a";
		System.out.println(new BackspaceString().backspaceCompare(S, T));
		
	}
}
