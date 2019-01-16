public class DistanceOfTwoNodesInBT {
	public int distance(TreeNode root, int k1, int k2) {
		int distanceOne = pathLenght(root, k1) - 1;
		int distanceTwo = pathLenght(root, k2) - 1;
		int lcaKey = findLCA(root, k1, k2).key;
		int distanceLca = pathLenght(root, lcaKey) - 1;
		return (distanceOne + distanceTwo) - 2 * distanceLca;
	}

	private int pathLenght(TreeNode root, int key) {
		if (root == null) {
			return 0;
		}

		if (root.key == key) {
			return 1;
		}

		int left = pathLenght(root.left, key);
		int right = pathLenght(root.right, key);

		if (left <= 0 && right <= 0) {
			return 0;
		}

		return left > 0 ? left + 1 : right + 1;
	}

	private TreeNode findLCA(TreeNode root, int k1, int k2) {
		if (root == null) {
			return null;
		}

		if (root.key == k1 || root.key == k2) {
			return root;
		}

		TreeNode left = findLCA(root.left, k1, k2);
		TreeNode right = findLCA(root.right, k1, k2);

		if (left != null && right != null) {
			return root;
		}

		return left == null ? right : left;
	}
}