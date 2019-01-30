public class AllSubsets {
	public List<String> subSets(String set) {
		// three levels.
		// each level use to determine whether put element in or not
		List<String> res = ArrayList<String>();
		if (set == null || set.length() == 0) {
			return res;
		}

		StringBuilder path = new StringBuilder();
		char[] helper = set.toCharArray();
		helper(helper, 0, path, res);
		return res;
	}

	private void helper(char[] set, int index, StringBuilder path, List<String> res) {
		if (index == set.length - 1) {
			res.add(path.toString());
			return;
		}

		// put in
		path.append(set[index]);
		helper(set, index + 1, path, res);
		path.deleteCharAt(path.length() - 1);
		// not put
		helper(set, index + 1, path, res);
	}

	// Time-cost = 1 + 2 + 4 + 8 + ... + 2^n = O(2^n)
	// Space-cost = O(n)
}