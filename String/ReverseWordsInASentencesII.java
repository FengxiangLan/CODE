public class ReverseWordsInASentencesII {
	public String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}

		char[] inputArray = input.toCharArray();
		int slow = 0;
		int fast = 0;
		String newStr = "";
		while (fast < inputArray.length) {
			if (inputArray[fast] == ' ' && (fast == 0) || inputArray[fast - 1] == ' ') {
				fast++;
			} else {
				inputArray[slow++] = inputArray[fast++];
			}
		}

		if (slow > 0 && inputArray[slow - 1] == ' ') {
			return reverse(new String(inputArray, 0, slow - 1));
		}
		return reverse(new String(inputArray, 0, slow));
	}

	public String reverse(String input) {
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