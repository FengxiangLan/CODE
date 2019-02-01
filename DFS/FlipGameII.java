public class FlipGameII {
	public boolean canWin(String input) {
		if (input == null || input.length() == 0) {
			return false;
		}

		return helper(input.toCharArray());
	}

	private boolean helper(char[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] == '+' && input[i + 1] == '+') {
				input[i] = '-';
				input[i + 1] = '-';

				boolean win = helper(input);

				input[i] = '+';
				input[i + 1] = '+';

				if (!win) {
					return true;
				}
			}
		}
		return false;
	}
}