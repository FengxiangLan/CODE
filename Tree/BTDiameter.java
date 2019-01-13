public class BTDiameter {
	public int diameter(TreeNode root) {
		int[] diameter = {0};
		if (root == null) {
			return 0;
		}
		helper(diameter, root);
		return diameter[0];
	}

	private int helper(int[] diameter, TreeNode root) {
		if (root == null) {
			return 0;
		}
    
		if (root.left == null) {
			return helper(diameter, root.right) + 1; 
		}

		if (root.right == null) {
			return helper(diameter, root.left) + 1;
		}

		int left = helper(diameter, root.left);
		int right = helper(diameter, root.right);
		int cur = left + right + 1;
		if (cur > diameter[0]) {
			diameter[0] = cur;
		}
		return Math.max(left, right) + 1;
	}
}