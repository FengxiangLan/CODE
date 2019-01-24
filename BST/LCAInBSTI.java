public class LCAInBSTI {
	public TreeNode lca(TreeNode root, int p, int q) {
		if (root == null) {
			return null;
		}

		if (root.key > p && root.key > q) {
			return lca(root.left, p, q);
		}

		if (root.key < p && root.key < q) {
			return lca(root.right, p, q);
		}

		return root;
	}
}