package may2020.week2;

class Node {
	boolean leaf;
	Node children[];

	public Node() {
		leaf = false;
		children = new Node[26];
	}
}

public class Trie {

	Node head;

	public Trie() {
		head = new Node();
	}

	public void insert(String word) {
		Node temp = head;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (temp.children[index] == null) {
				temp.children[index] = new Node();
			}
			temp = temp.children[index];
		}
		if (temp != null)
			temp.leaf = true;
	}

	public boolean search(String word) {
		Node temp = head;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (temp.children[index] == null) {
				return false;
			}
			temp = temp.children[index];
		}
		return temp.leaf;
	}

	public boolean startsWith(String prefix) {
		Node temp = head;
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (temp.children[index] == null)
				return false;
			temp = temp.children[index];
		}
		return true;
	}
}
