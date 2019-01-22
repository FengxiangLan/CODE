public class InsertBST {
	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			root == new TreeNode(key);
		} else if (root.key == key) {
			return root;
		} else if (root.key < key) {
			root = insert(root.right, key);
		} else {
			root = insert(root.left, key);
		}

		return root;
	}
}