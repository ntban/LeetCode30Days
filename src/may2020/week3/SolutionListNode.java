package may2020.week3;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
@Override
public String toString() {

	return val+"";
}
}

public class SolutionListNode {
	void print(ListNode node) {
		while (node != null) {
			System.out.printf("%d ", node.val);
			node = node.next;
		}
		System.out.println();
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode node = head;
		if (node == null || node.next == null)
			return head;
		ListNode startEven = node.next;
		ListNode endOdd1 = node;
		ListNode endOdd2 = node;
		int i = 1;
		while (node != null && node.next != null) {
			ListNode following = node.next;
			if (i % 2 == 1) {
				endOdd1 = node;
				endOdd2 = node.next.next;
			}
			node.next = node.next.next;
			i++;
			node = following;
		}
		if(i % 2 == 0) endOdd1.next = startEven;
		else endOdd2.next = startEven;
		return head;
	}

	public static void main(String[] args) {
		int[] a = { 2,1,3,5,6,4,7};
		ListNode nodes[] = new ListNode[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			nodes[i] = new ListNode(a[i]);
			if(i < a.length - 1) {
				nodes[i].next =  nodes[i+1];
			}
		}
		SolutionListNode solution = new SolutionListNode();
		solution.print(nodes[0]);
		ListNode head = solution.oddEvenList(nodes[0]);
		solution.print(head);
	}
}