public class AllValidPermutations {
	public List<String> validParentheses(int n) {
		List<String> res = new ArrayList<String>();
		StringBuilder path = new StringBuilder();
		helper(n, 0, path, res);
		return res;
	}

	private void helper(int n, int left, StringBuilder path, List<String> res) {
		if (path.length() == n * 2) {
			if (left == 0) {
				res.add(path.toString());
			}
			return;
		}

		if (left < n) {
			path.append('(');
			helper(n, left + 1, path, res)；
			path.deleteCharAt(path.length() - 1);
		}

		if (left > 0) {
			path.append(')');
			helper(n, left - 1, path, res);
			path.deleteCharAt(path.length() - 1);
		} 
	}
}