public class InsertInBST {
	// Recursion: A very common way when the tree structure could be changed, 
	// in this case, we return the new root after the change 
	// (remind about the same case of Linked List)
	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			TreeNode newRoot = new TreeNode(key);
			return newRoot;
		}

		if (root.key < key) {
			root.right = insert(root.right, key);
		}else if (root.key > key) {
			root.left = insert(root.left, key);
		}

		return root;
	}

	// Iterative
	public TreeNode insert(TreeNode root, int key) {
		TreeNode newNode = new TreeNode(key);
		if (root == null) {
			return newNode;
		}

		TreeNode current = root;
		while (current.key != key) {
			if (current.key > key) {
				if (current.left != null) {
					current = current.left;
				}else {
					current.left = newNode;
					break;
				}
			}else {
				if (current.right != null) {
					current = current.right;
				}else {
					current.right = newNode;
					break;
				}
			}
		}
		return root;
	}
}