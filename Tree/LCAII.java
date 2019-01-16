public class LCAII {
	public TreeNodeP LCA(TreeNodeP one, TreeNodeP two) {
		int levelOfOne = level(one);
		int levelOfTwo = level(two);

		if (levelOfOne <= levelOfTwo) {
			return parent(one, two, levelOfTwo - levelOfOne);
		}else {
			return parent(two, one, levelOfOne - levelOfTwo);
		}
	}

	private int level(TreeNodeP node) {
		int level = 0;
		while (node != null) {
			level++;
			node = node.parent;
		}
		return level;
	}

	private TreeNodeP parent(TreeNodeP low, TreeNodeP hight, int diff) {
		while (diff > 0) {
			low = low.parent;
			diff--;
		}

		while (hight != low) {
			hight = hight.parent;
			low = low.parent;
		}

		return hight;
	}
}