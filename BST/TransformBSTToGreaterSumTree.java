public class TransformBSTToGreaterSumTree {
	public TreeNode greaterSum(TreeNode root) {
		int[] sum = new int[] {0};
		helper(root, sum);
		return root;
	}

	private void helper(TreeNode node, int[] sum) {
		if (node == null) {
			return;
		}

		helper(node.right, sum);
		sum[0] = sum[0] + node.key;
		node.key = sum[0] - node.key;
		helper(node.left, sum);
	} 
}