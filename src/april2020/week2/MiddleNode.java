package april2020.week2;

public class MiddleNode {
	public ListNode middleNode(ListNode head) {
		if (head == null)
			return null;
		ListNode tortoise = head;
		ListNode hare = tortoise.next;
		while (hare != null && hare.next != null) {
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		if (hare != null) {
			tortoise = tortoise.next;
		}
		return tortoise;
	}

	public ListNode buildList(int arr[]) {
		if (arr != null && arr.length > 0) {
			ListNode head = new ListNode(arr[0]);
			ListNode temp = head;
			for (int i = 1; i < arr.length; i++) {
				ListNode node = new ListNode(arr[i]);
				temp.next = node;
				temp = temp.next;
			}
			return head;
		}
		return null;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		MiddleNode solution = new MiddleNode();
		ListNode head = solution.buildList(arr);
		ListNode result = solution.middleNode(head);
		result.print();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	void print() {
		System.out.printf("%d ", val);
		ListNode temp = next;
		while (temp != null) {
			System.out.printf("%d ", temp.val);
			temp = temp.next;
		}
		System.out.println();
	}
}
