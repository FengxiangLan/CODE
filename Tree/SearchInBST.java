public class SearchInBST {
	// Recursive
	public TreeNode search(TreeNode root, int target) {
		// process root
		if (root == null || root.key == target) {
			return root;
		}

		// check left node if target less than root.key
		if (target < root.key) {
			return search(root.left, target);
		}else {
			return search(root.right, target);
		}
	}

	public TreeNode search(TreeNode root, int target) {
		TreeNode currentNode = root;
		while (currentNode != null && currentNode.key != target) {
			if (target < currentNode.key) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		// exit while loop: currentNode = null || currentNode.key == target
		return currentNode;
	}
}