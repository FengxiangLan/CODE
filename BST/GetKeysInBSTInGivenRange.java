public class GetKeysInBSTInGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		helper(root, min, max, res);
		return res;
	}

	private void helper(TreeNode node, int min, int max, List<Integer> res) {
		if (node == null) {
			return;
		}

		if (node.key > min) {
			helper(node.left, min, max, res);
		}

		if (node.key >= min && node.key <= max) {
			res.add(node.key);
		}

		if (node.key < max) {
			helper(node.right, min, max, res);
		}
	}
}