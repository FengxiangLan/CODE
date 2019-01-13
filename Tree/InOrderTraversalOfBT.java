public class InOrderTraversalOfBT {
	// Recursive
	public List<Integer> inOrder(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		helper(res, root);
		return res;
	}

	private void helper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}

		helper(res, root.left);
		res.add(root.key);
		helper(res, root.right); 
	}

	// Iterative
	public List<Integer> inOrder(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			}else {
				cur = stack.pollFirst();
				res.add(cur.key);
				cur = cur.right;
			}
		}
		return res;
	}
}
