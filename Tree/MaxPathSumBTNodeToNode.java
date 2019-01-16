public class MaxPathSumBTNodeToNode {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[] {Integer.MIN_VALUE};
		if (root == null) {
			return max;
		}

		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode node, int[] max) {
		if (node == null) {
			return 0;
		}

		int left = helper(node.left, max);
		int right = helper(root.right, max);
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max[0] = Math.max(max[0], left + right + node.key);
		return Math.max(left, right) + node.key;
	}
}