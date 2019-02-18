public class BTIsMinHeap {
	public boolean isMinHeap(TreeNode root) {
		// Write your solution here
		return isComplete(root) && isHeap(root);
	}

	private boolean isHeap(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (root.left == null) {
			return true;
		}

		if (root.left != null && root.left.key < root.key) {
			return false;
		}

		if (root.right == null) {
			return true;
		}

		if (root.right != null && root.right.key < root.key) {
			return false;
		}

		return isHeap(root.left) && isHeap(root.right);
	}

	private boolean isComplete(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		boolean flag = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			if (curNode.left == null) {
				flag = true;
			}
			else if (flag) {
				return false;
			}
			else {
				queue.offer(curNode.left);
			}

			if (curNode.right == null) {
				flag = true;
			}
			else if (flag) {
				return false;
			}
			else {
				queue.offer(curNode.right);
			}
		}
		return true;
	}
}
