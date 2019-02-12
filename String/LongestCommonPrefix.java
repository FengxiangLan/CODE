public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		return helper(strs, 0, strs.length - 1);
	}

	private String helper(String[] strs, int left, int right) {
		if (left == right) {
			return strs[left];
		}

		int mid = left + (right - left) / 2;
		String lcpLeft = helper(strs, left, mid);
		String lcpRight = helper(strs, mid + 1, right);
		return common(lcpLeft, lcpRight);
	}

	private String common(String left, String right) {
		int min = Math.min(left.length(), right.length());
		for (int i = 0; i < min; i++) {
			if (left.charAt(i) != right.charAt(i)) {
				return left.substring(0, i);
			}
		}
		return left.substring(0, min);
	}
}