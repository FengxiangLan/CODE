public class AllPermutationsII {
	public List<String> permutations(String input) {
		List<String> res = new ArrayList<>();
		if (input == null || input.length() == 0) {
			return res;
		}

		char[] inputArray = input.toCharArray();
		helper(inputArray, 0, res);
		return inputArray;
	}

	private void helper(char[] inputArray, int index, List<String> res) {
		if (index == array.length) {
			res.add(new String(inputArray));
			return;
		}

		Set<Character> used = new HashSet<>();
		for (int i = index; i < inputArray.length; i++) {
			if (used.add(inputArray[index])) {
				swap(array, i, index);
				helper(array, index + 1, res);
				swap(array, i, index);
			}
		}
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}