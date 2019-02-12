public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		return match(input, pattern, 0, 0);
	}

	private boolean match(String input, String pattern, int i, int j) {
		if (i == input.length() && j == pattern.length()) {
			return true;
		}

		if (i >= input.length() || j >= pattern.length()) {
			return false;
		}

		if (pattern.charAt(j) < '0' || pattern.charAt(j) > '9') {
			if (input.charAt(i) == pattern.charAt(j)) {
				return match(input, pattern, i++, j++);
			} 
			return false;
		}

		int cnt = 0;
		while (j < pattern.length() && pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
			cnt = cnt * 10 + (pattern.charAt(j) - '0');
			j++;
		}

		return match(input, pattern, i + cnt, j);
	}
}