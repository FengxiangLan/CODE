public class RecoverBST {
	// 1254367
	// 1234567
	public TreeNode recover(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode[] first = new TreeNode[1] {null};
		TreeNode[] second = new TreeNode[1] {null};
		TreeNode[] prev = new TreeNode[1] {new TreeNode(Integer.MIN_VALUE)};
		inorder(root, first, second, prev);
		int temp = first[0].key;
		first[0].key = second[0].key;
		second[0].key = temp;
		return root;
	}

	private void inorder(TreeNode node, TreeNode[] first, TreeNode[] second, TreeNode[] prev) {
		if (node == null) {
			return;
		}

		inorder(node.left, first, second, prev);
		if (first[0] == null && node.key < prev[0].key) {
			first[0] = prev[0];
		}

		if (first[0] != null && node.key < prev[0].key) {
			second[0] = node;
		}

		prev[0] = node;
		inorder(node.right, first, second, prev);
	}
}