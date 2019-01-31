public class AllPermutations {
	public List<String> permutations(String set) {
		// n level, 
		// in this level what we should put in this position of set
		List<String> res = new ArrayList<String>();
		if (set == null && set.length() == 0) {
			return res;
		}

		char[] arraySet = set.toCharArray();
		helper(arraySet, 0, res);
		return res;
	}

	private void helper(char[] set, int index, List<String> res) {
		if (index == set.length) {
			res.add(new String(arraySet));
		}

		for (int i = index, i < set.length; i++) {
			swap(set, index, i);
			helper(set, index + 1, res);
			swap(set, index, i);
		}
	}

	private void swap(char[] set, int a, int b) {
		char temp = set[a];
		set[a] = set[b];
		set[b] = temp;
	}

	// Time-cost = O(n!)
	// Space-cost = o(n)
}