public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		int n = input.length();
		for (int i = 0; i < n; i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				List<Integer> lval= diffWaysToCompute(left);
				Collections.sort(lval);
				List<Integer> rval = diffWaysToCompute(right);
				Collections.sort(rval);
				for (int l : lval) {
					for (int r : rval) {
						if (input.charAt(i) == '+') {
							res.add(l + r);
						} else if (input.charAt(i) == '-') {
							res.add(l - r);
						} else if (input.charAt(i) == '*') {
							res.add(l * r);
						}
					}
				}
			}
		}
		if (res.isEmpty()) {
			res.add(Integer.parseInt(input));
		}
		Collections.sort(res);
		return res;
	}
}