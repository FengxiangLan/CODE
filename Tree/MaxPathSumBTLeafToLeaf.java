public class MaxPathSumBTLeafToLeaf {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[] {Integer.MIN_VALUE};
		if (root == null) {
			return max;
		}
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return root.key;
		} 

		int left = helper(root.left, max);
		int right = helper(root.right, max);

		if (node.left != null && node.right != null) {
			max[0] = Math.max(max[0], left + right + root.key);
			return Math.max(left, right) + root.key;
		} 

		return root.left == null ? right + root.key : left + root.key;
	}
}