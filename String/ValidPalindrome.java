public class ValidPalindrome {
	public boolean valid(String input) {
		if (input == null || input.length() == 0) {
			return true;
		}

		input = input.toUpperCase();
		int left = 0;
		int right = input.length() - 1;
		while (left < right) {
			if ((input.charAt(left) < 'A' || input.charAt(left) > 'Z') && (input.charAt(left) < '0' || input.charAt(left) > '9')) {
		        left++;
		        continue;
			}
			if ((input.charAt(right) < 'A' || input.charAt(right) > 'Z') && (input.charAt(right) < '0' || input.charAt(right) > '9')) {
				right--;
				continue;
			}

			if (input.charAt(left) == input.charAt(right)) {
				left++;
				right--;
			}
			else {
				return false;
			}
		}
		return true;
	}
}