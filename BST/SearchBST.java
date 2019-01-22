public class SearchBST {
	public TreeNode search(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		while (root != null) {
			if (root.key == key) {
				return root;
			} else if (root.key > key) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return null;
	}
}