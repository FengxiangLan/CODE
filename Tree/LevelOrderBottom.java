public class LevelOrderBottom {
	public List<Integer> LevelOrderBottom(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> curList = new LinkedList<TreeNode>();
		curList.offer(root);

		while (!curList.isEmpty()) {
			int size = curList.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode cur = curList.poll();
				res.add(cur.key);
				if (cur.left != null) {
					curList.add(cur.left);
				}

				if (cur.right != null) {
					curList.add(cur.right);
				}
			}

			if (curList.isEmpty()) {
				break;
			}else {
				res = new ArrayList<Integer>();
			}
		}
		return res;
	}
}