public class DeleteInBST {
	public TreeNode delete(TreeNode root, int target) {
		if (root == null) {
			return null;
		}

		if (root.key < target) {
			root.right = delete(root.right, target);
		}
		else if (root.key > target) {
			root.left = delete(root.left, target);
		}
		else {
			if (root.left == null && root.right == null) {
				return null;
			} 
			else if (root.left == null || root.right == null) {
				return root.left == null ? root.right : root.left;
			}
			else if (root.right.left == null) {
				root.right.left = root.left;
				return root.right;
			}
			else {
				TreeNode newRoot = findSmallest(root.right);
				newRoot.left = root.left;
				newRoot.right = root.right;
				return newRoot;
			}
		}
		return root;
	}

	private TreeNode findSmallest(TreeNode root) {
		while (root.left != null && root.left.left != null) {
			root = root.left;
		}
		TreeNode node = root.left;
		root.left = root.left.right;
		return node;
	}
}