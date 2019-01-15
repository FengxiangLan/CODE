public class CountUnivalueSubtree {
	public int countUnivalSubtrees(TreeNode root) {
		int[] res = {0};
		isUnival(root, res);
		return res[0];
	}

	private boolean isUnival(TreeNode root, int res) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			res[0]++;
			return true;
		}

		boolean left = isUnival(root.left, res);
		boolean right = isUnival(root.right, res);
		if (left && right && (root.left == null || root.left.key == root.key) && (root.right == null || root.right.key == root.key)) {
			res[0]++;
			return true;
		}
		return false;
	}
}