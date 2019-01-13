public class CheckIfBTIsBalanced {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = getHeight(node.left);
		int right = getHeight(node.right);
		return Math.max(left, right) + 1;
	}
}