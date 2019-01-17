public class RightViewOfBT {
	public List<Integer> rightView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> nodeList = new LinkedList<TreeNode>();
		nodeList.offer(root);
		while (!nodeList.isEmpty()) {
			int size = nodeList.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = nodeList.poll();
				if (cur.left != null) {
					nodeList.offer(cur.left);
				}

				if (cur.right != null) {
					nodeList.offer(cur.right);
				}

				if (i == size - 1) {
					res.add(cur.key);
				}
			}

			res.add(nodeList.poll().key);
		}
		return res;
	}
}