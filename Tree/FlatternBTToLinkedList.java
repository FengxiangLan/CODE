public class FlatternBTToLinkedList {
	public TreeNode flatten(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode newRoot = root;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root.right != null) {
				stack.offerFirst(root.right);
			}

			if (root.left != null) {
				root.right = root.left;
				root.left = null;
			} else if (!stack.isEmpty()){
				TreeNode temp = stack.pollFirst();
				root.right = temp;
			}			

			root = root.right;
		}

		return newRoot;

	}
}