public class LevelTraversal {
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> nodeList = new LinkedList<TreeNode>();
		nodeList.offer(root);
		while (!nodeList.isEmpty()) {
			List<Integer> curLayer = new ArrayList<Integer>();
			int size = nodeList.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = nodeList.poll();
				curLayer.add(cur.key);
				if (cur.left != null) {
					nodeList.offer(cur.left);
				}

				if (cur.right != null) {
					nodeList.offer(cur.right);
				}
			}
			res.add(curLayer);
		}
		return res;
	}
}