public class KthSmallestElementInBST {
	public int kthSmallest(TreeNode root, int k) {
		int res = Integer.MIN_VALUE;
		Deque<TreeNode> stack = new LinkedList<>();

		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.offerFirst(root);
				root = root.left;
			} else {
				TreeNode temp = stack.pollFirst();
				k--;
				if (k == 0) {
					res = temp.key;
				}
				root = temp.right;
			}
		}
		return res;
	}
}