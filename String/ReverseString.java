public class ReverseString {
	public String reverse(String input) {
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