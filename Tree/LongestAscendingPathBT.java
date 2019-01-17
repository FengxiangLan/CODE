public class LongestAscendingPathBT {
	public int longest(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int[] longest = new int[] {1};
		helper(root, 0, root.key, longest);
		return longest[0];
	}

	private void helper(TreeNode node, int len, int prevValue, int[] longest) {
		if (node == null) {
			return;
		}

		if (node.key > prevValue) {
			len++;
		}else {
			len = 1;
		}

		longest[0] = Math.max(longest[0], len);
		helper(node.left, len, node.key, longest);
		helper(node.right, len, node.key, longest);
	}
}