public class ValidPalindrome {
	public boolean validPalindrome(String input) {
		// once we meet left != right, we should consider whether
		// 	1. left + 1 == right
		//  2. left == right - 1
		if (input == null || input.length() == 0) {
			return true;
		}

		int left = 0;
		int right = input.length() - 1;
		while (left < right) {
			if (input.charAt(left) == input.charAt(right)) {
				left++;
				right--;
			} else {
				return isPalidrome(input, left + 1, right) || isPalidrome(input, left, right - 1);
			}
		}

		return true;
	}

	private boolean isPalidrome(String input, int left, int right) {
		if (left >= right) {
			return true;
		}

		while (left < right) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}
}