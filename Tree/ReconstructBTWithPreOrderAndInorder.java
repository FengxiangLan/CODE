public class ReconstructBTWithPreOrderAndInorder {
	public TreeNode reconstruct(int[] in, int[] pre) {
		int[] inIndex = new int[] {0};
		int[] preIndex = new int[] {0};

		return helper(in, inIndex, pre, preIndex, Integer.MAX_VALUE);
	}

	private TreeNode helper(int[] in, int[] inIndex, int[] pre, int[] preIndex, int target) {
		if (inIndex[0] >= in.length || in[inIndex[0]] == target) {
			return null;
		}

		TreeNode root = new TreeNode(pre[preIndex[0]]);
		preIndex[0]++;
		root.left = helper(in, inIndex, pre, preIndex, root.key);
		inIndex[0]++;
		root.right = helper(in, inIndex, pre, preIndex, target);
	}	
}