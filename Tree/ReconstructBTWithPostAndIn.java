public class ReconstructBTWithPostAndIn {
	//[left][right][root] post
	//[left][root][right] in
	public TreeNode reconstruct(int[] in, int post) {
		int inStart = 0;
		int inEnd = in.length - 1;
		int postStart = 0;
		int postEnd = post.length - 1;
		return helper(in, inStart, inEnd, post, postStart, postEnd) 
	}

	private TreeNode helper(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		TreeNode node = new TreeNode(post[postEnd]);

		int k = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == node.key) {
				k = i;
				break;
			}
		}

		root.left = helper(in, inStart, k - 1, post, postStart, postStart + k - (inStart + 1));
		root.right = helper(in, k + 1, inEnd, post, postStart + k - inStart, postEnd - 1);

		return root;
	}
}