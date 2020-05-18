package april2020.week3;

public class BstFromPreorder {
	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0)
			return null;
		TreeNode head = new TreeNode(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			TreeNode node = new TreeNode(preorder[i]);
			insertToBst(head, node);
		}
		return head;
	}

	void insertToBst(TreeNode head, TreeNode node) {
		if (node.val < head.val) {
			if (head.left == null) {
				head.left = node;
			} else {
				insertToBst(head.left, node);
			}
			return;
		}
		if (head.right == null) {
			head.right = node;
		} else {
			insertToBst(head.right, node);
		}

	}

	void preorder(TreeNode node) {
		if (node == null)
			return;
		System.out.printf("%d ", node.val);
		preorder(node.left);
		preorder(node.right);
	}

	TreeNode build(Integer a[], int i) {
		if (i >= a.length || a[i] == null)
			return null;
		TreeNode head = new TreeNode(a[i]);
		head.left = build(a, 2 * i + 1);
		head.right = build(a, 2 * i + 2);
		return head;
	}

	public static void main(String[] args) {
//		Integer a[] = { 8, 5, 10, 1, 7, null, 12 };
		BstFromPreorder solution = new BstFromPreorder();
//		TreeNode head = solution.build(a, 0);
//		solution.preorder(head);
		
		int preorder[] = {100,50,40,30,34,33,38,45,41,46,150,148,149};
		TreeNode bstFromPreorder = solution.bstFromPreorder(preorder);
		solution.preorder(bstFromPreorder);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return val + "";
	}
}
