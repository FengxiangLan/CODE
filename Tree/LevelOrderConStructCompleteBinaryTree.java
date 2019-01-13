public class LevelOrderConStructCompleteBinaryTree {
	public TreeNode construct(int[] level) {
		if (level.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(level[0]);
		TreeNode cur = null;
		int cnt = 0;
		Queue<TreeNode> nodeList = new LinkedList<TreeNode>();
		nodeList.offer(root);
		for (int i = 1; i < level.length; i++) {
			TreeNode node = new TreeNode(level[i]);
			if (cnt == 0) {
				cur = nodeList.poll();
			}

			if (cnt == 0) {
				cur.left = node;
				cnt++;
			}else {
				cur.right = node;
				cnt = 0;
			}

			nodeList.offer(node);
		}
		return root;
	}
}