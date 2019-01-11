public class BTPathSumToTargetI {
	public boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}

		target -= root.key;
		if (root.left == null && root.right == null) {
			return target == 0;
		}		
		return exist(root.left, target) || exist(root.right, target);
	}
}