public class RemoveCertainCharacters {
	public String remove(String input, String t) {
		char[] inputArray = input.toCharArray();
		Set<Character> set = getSet(t);
		int slow = 0;
		int fast = 0;
		while (fast < inputArray.length) {
			if (!set.contains(inputArray[fast])) {
				inputArray[slow++] = inputArray[fast++];
			} else {
				fast++;
			}
		}

		return new String(inputArray, 0, slow);
	}

	private Set<Character> getSet(String input) {
		Set<Character> set = new HashSet<>();
		if (input == null || input.length() == 0) {
			return set;
		}

		for (int i = 0; i < input.length(); i++) {
			set.add(input.charAt(i));
		}

		return set;
	}
}