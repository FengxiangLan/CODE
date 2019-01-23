public class SecondLargestInBST {
	public int secondLargest(TreeNode root) {
		TreeNode prev = null;
		int res = Integer.MIN_VALUE;
		if (root.left == null && root.right == null) {
			return res;
		}
		while (root.right != null) {
			prev = root;
			root = root.right;
		}

		if (root.left != null) {
			root = root.left;
			while (root.right != null) {
				root = root.right;
			}
			res = root.key;
		} else {
			res = Math.min(res, prev.key);
		}
		return res;
	}
}