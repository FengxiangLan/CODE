public class RightShiftByNCharacters {
	public String rightShift(String input, int n) {
		if (input == null || input.length() == 0) {
			return input;
		}

		char[] array = input.toCharArray();
		int n = n % array.length;
		reverse(array, 0, array.length - 1);
		reverse(array, 0, n - 1);
		reverse(array, n, array.length - 1);
		return new String(array);
	}

	private void reverse(char[] array, int start, int end) {
		if (array == null || array.length == 0 || start < 0 || start > array.length - 1 || end < 0 || end > array.length - 1) {
			return;
		}

		while (start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--; 
		}
	}
}