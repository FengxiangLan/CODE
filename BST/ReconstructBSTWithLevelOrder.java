public class ReconstructBSTWithLevelOrder {
	// 5 [3, 8] [1, 4] 
	public TreeNode reconstruct(int[] level) {
		if (level.length == 0) {
			return null;
		}

		List<Integer> list = new ArrayList<>(level.length);
		for (int i : level) {
			list.add(i);
		}
		
		return helper(list);
	}

	private TreeNode helper(List<Integer> list) {
		if (list.size() == 0) {
			return null;
		}

		TreeNode node = new TreeNode(list,remove(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (Integer key : list) {
			if (key < node.key) {
				left.add(key);
			} else {
				right.add(key);
			}
		}

		node.left = helper(left);
		node.right = helper(right);

		return node;
	}
}