public class CousinsInBT {
	public boolean isCousin(TreeNode root, int a, int b) {
		if (root == null) {
			return false;
		}

		boolean[] res = new boolean[] {false};
		helper(root, a, b, 0, res);
		return res[0];
	}

	private int helper(TreeNode root, int a, int b, int level, boolean[] res) {
		if (root == null) {
			return -1;
		}

		if (root.key == a || root.key == b) {
			return level;
		}

		int left = helper(root.left, a, b, level + 1, res);
		int right = helper(root.right, a, b, level + 1, res);
		if (left == right && (left - level > 1)) {
			res[0] = true;
		}

		return Math.max(left, right);
	}
}