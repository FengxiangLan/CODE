public class ValidPostOrder {
	public boolean validPostOrder(int[] post) {
		// post left right root
		if (post.length == 0) {
			return true;
		}

		List<Integer> list = new ArrayList<>(post.length);
		for (int i : post) {
			list.add(i);
		}

		return helper(list);
	}

	private boolean helper(List<Integer> list) {
		if (list.size() == 0) {
			return true;
		}

		Integer node = list.remove(list.size() - 1);
		List<Integer> left = new ArrayList<>();
		while (!list.isEmpty()) {
			if (list.get(0) < node) {
				left.add(list.remove(0));
			} else {
				break;
			}
		}

		List<Integer> right = list;
		for (int i = 0; i < right.size(); i++) {
			if (right.get(i) < node) {
				return false;
			}
		}

		return helper(left) && helper(right);
	}
}