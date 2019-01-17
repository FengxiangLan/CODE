public class BTPathSumToTargetIII {
	public boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}

		Set<Integer> prefixSum = new HashSet<>();
		prefixSum.add(0);
		return helper(root, prefixSum, 0, target);
	}

	private boolean helper(TreeNode node, Set<Integer> prefixSum, int prevSum, int target) {
		prevSum += node.key;
		if (prefixSum.contains(prevSum - target)) {
			return true;
		}

		boolean needRemove = prefixSum.add(prevSum);
		if (node.left != null && helper(node.left, prefixSum, prevSum, target)) {
			return true;
		}

		if (node.right != null && helper(node.right, prefixSum, prevSum, target)) {
			return true;
		}

		if (needRemove) {
			prefixSum.remove(prevSum);
		}

		return false;
	}
}

