public class BinaryTreePaths {
	public String[] binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) {
			return res.toArray(new String[0]);
		}

		helper(root, "", res);
		return res.toArray(new String[res.size()]);
	}

	private void helper(TreeNode root, String path, List<String> res) {
		if (root != null) {
			path += Integer.toString(root.key);
			if (root.left == null && root.right == null) {
				res.add(path);
			}
			else {
				path += "->";
				helper(root.left, path, res);
				helper(root.right, path, res);
			}
		}
	}
}