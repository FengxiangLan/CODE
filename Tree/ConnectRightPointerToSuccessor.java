public class ConnectRightPointerToSuccessor {
	public void connect(TreeNode root) {
		if (root == null) {
			return;
		}

		Deque<TreeNode> stack = new LinkedList<>();
		Map<TreeNode, TreeNode> hashMap = new HashMap<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			}else {
				cur = stack.pollFirst();
				if (cur.right == null) {
					hashMap.put(cur, stack.peek());
				}     
				cur = cur.right;
			}
		}

		for(Map.Entry<TreeNode, TreeNode> entry : hashMap.entrySet()) {
			entry.getKey().right = entry.getValue();
		}
	}
}

