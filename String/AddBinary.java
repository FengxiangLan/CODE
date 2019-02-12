public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		while (i >= 0 || j >= 0 || carry != 0) {
			int x = (i >= 0) ? a.charAt(i) - '0' : 0;
			int y = (j >= 0) ? b.charAt(j) - '0' : 0;

			int sum = x + y + carry;
			if (sum == 0) {
				res.append('0');
				carry = 0;
			} else if (sum == 1) {
				res.append('1');
				carry = 0;
			} else if (sum == 2){
				res.append('0');
				carry = 1;
			} else {
				res.append('1');
				carry = 1;
			}
			i--;
			j--;
		}
		return reverse(res.toString());
	}

	private String reverse(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}

		char[] array = input.toCharArray();
		helper(array, 0, array.length - 1);
		return new String(array);
	}

	private void helper(char[] array, int i, int j) {
		if (i >= j) {
			return;
		}

		swap(array, i, j);
		helper(array, i + 1, j - 1);
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}