public class DeleteInBST {
	// Step one: find the node to be deleted, easy
	// Step two: delete it, not easy

	// case 1: the node to be deleted has no chilren
	// case 2: the node to be deleted has no left child
	// case 3: the node to be deleted has no right child
	// case 4: the node to be deleted has both left and right child.
	// Which node to replace this node?
	//   from right sub of this node, smallest of the right subtree

	// case 4.1: node.right does node have left child, meaning node.right 
	// is the smallest node in this case, we just move node.right up
	// root = target
	// root.right = xxx
	// root.right.left = null
	// root.right.left = root.left

	// case 4.2: node.right has left child, we need to find the smallest node, and move it up
	// root = target
	// root.right.left.left.left....until == null
	public TreeNode delete(TreeNode root, int target) {
		if (root == null) {
			return root;
		}

		// find target node
		if (root.key > target) {
			root.left = delete(root.left, target);
			return root;
		}else if (root.key < target) {
			root.right = delete(root.right, target);
			return right;
		}

		if (root.left == null) {
			return root.right;
		}else if (root.right == null) {
			return root.left;
		}

		if (root.right.left == null) {
			root.right.left = root.left;
			return root.right;
		}

		TreeNode smallest = deleteSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;
	}

	private TreeNode deleteSmallest(TreeNode cur) {
		TreeNode prev = cur;
		cur = cur.left;
		while (cur.left != null) {
			prev = cur;
			cur = cur.left;
		}

		// cur is the smallest node. prev is its parent;
		prev.left = prev.left.right;
		return cur;
	}

}