public class GetPostByPreAndIn {
	// in [left][root][right]
	// pre [root][left][right]
	// post[left][right][root]
	public int[] postOrder(int[] pre, int[] in) {
		int inStart = 0;
		int inEnd = in.length - 1;
		int[] preIndex = new int[] {0};
		List<Integer> help= new ArrayList<>();
		int[] post = new int[in.length];  
		helper(in, pre, inStart, inEnd, preIndex, help);
		for (int i = 0; i < post.length - 1; i++) {
			post[i] = help.get(i);
		}	
		return post;
	}

	private void helper(int[] in, int[] pre, int inStart, int inEnd, int[] preIndex, List<Integer> help) {
		if (inStart > inEnd) {
			return;
		}

		int inIndex = search(in, inStart, inEnd, pre[preIndex[0]++]);

		helper(in, pre, inStart, inIndex - 1, prevIndex, help);
		helper(in, pre, inIndex + 1, inEnd, prevIndex, help);

		help.add(in[inIndex]);

	}

	private int search(int[] in, int inStart, int inEnd, int data) {
		int i = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (in[i] == data) {
				return i;
			}
		}
		return i;
	}
}