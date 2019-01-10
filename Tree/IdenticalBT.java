public class IdenticalBT {
	public boolean isIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}

		return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
	}
}