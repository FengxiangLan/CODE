public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		for (int i = 1; i <= num.length() / 2; i++) {
			if (num.charAt(0) == '0' && i > 1) {
				continue;
			}
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) == 0 && j - i > 1) {
					continue;
				}

				if (helper(num, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(String num, int i, int j, int k) {
		long num1 = Long.parseLong(num.substring(i, j));
		long num2 = Long.parseLong(num.substring(j, k));

		String add = String.valueOf(num1 + num2);

		if (!num.substring(k).startsWith(add)) {
			return false;
		}

		if (k + add.length() == num.length()) {
			return true;
		}

		return helper(num, j, k, k + add.length());
	}

}