public class ReconstructBSTWithPre {
	//[root][left][right]
	public TreeNode reconstruct(int[] pre) {
		if (pre.length == 0) {
			return null;
		}

		return helper(pre, 0, pre.length - 1);
	}

	private TreeNode helper(int[] pre, int start, int end) {
		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(pre[start]);
		int index = findIndex(pre, pre[start], start, end);
		node.left = helper(pre, start + 1, index - 1);
		node.right = helper(pre, index, end);

		return node;
	}

	private int findIndex(int[] pre, int data, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (pre[i] > data) {
				return i;
			}
		}

		return end + 1;
	}
}