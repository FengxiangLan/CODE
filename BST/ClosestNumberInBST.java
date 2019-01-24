public class ClosestNumberInBST {
	public int cloest(TreeNode root, int target) {
		int res = root.key;
		while (root != null) {
			if (root.key == target) {
				return root.key;
			}
			else {
				if (Math.abs(root.key - target) < Math.abs(res - target)) {
					res = root.key;
				}

				root = root.key < target ? root.right : root.left;
			}
		}
		return res;
	}
}