public class PreOrderTraversalOfBT {
	// Recursive
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preOrder(res, root);
		return res;
	}

	private void preOrder(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}

		res.add(root.key);
		preOrder(res, root.left);
		preOrder(res, root.right);
	}

	// Iterative
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}

			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}

			res.add(cur.key);
		}
		return res;
	}
}
