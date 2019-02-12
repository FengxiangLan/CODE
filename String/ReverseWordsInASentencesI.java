public class ReverseWordsInASentencesI {
	public String reverseWords(String input) {
		// corner case
		if (input == null || input.length() == 0) {
			return input;
		}

		char[] array = input.toCharArray();
		reverse(array, 0, array.length - 1);
		int start = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
				start = i;
			}

			if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
				reverse(array, start, i);
			}
		}

		return new String(array);
	}

	private void reverse(char[] array, int left, int right) {
		if (left >= right) {
			return;
		}

		while (left < right) {
			swap(array, left++, right--);
		}
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}