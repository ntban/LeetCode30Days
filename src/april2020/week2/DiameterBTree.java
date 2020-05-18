package april2020.week2;

public class DiameterBTree {
	
	int ans = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null ) {
			return 0;
		}
		height(root);
		return ans;
	}
	
	int height(TreeNode node) {
		if (node == null) return 0;
		int left = height(node.left) + 1;
		int right = height(node.right) + 1;
		ans = Math.max(ans, left + right - 2);
		return Math.max(left, right);
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4, 5 };
		TreeNode nodes[] = new TreeNode[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new TreeNode(arr[i]);
		}
//		nodes[1].left = nodes[2];
//		nodes[1].right = nodes[3];
		nodes[2].left = nodes[4];
		nodes[2].right = nodes[5];

		DiameterBTree solution = new DiameterBTree();
		System.out.println(solution.diameterOfBinaryTree(nodes[1]));

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}