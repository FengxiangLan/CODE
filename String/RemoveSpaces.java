public class RemoveSpaces {
	public String removeSpaces(String input) {
		// Given a string, remove all leading/trailing/duplicated empty spaces.
		// if fast == " " and (fast == start or fast - 1 == " ")
		//  fast++;
		// else 
		// slow ++ = fast ++
		if (input == null || input.length() == 0) {
			return input;
		}

		char[] inputArray = input.toCharArray();
		int slow = 0;
		int fast = 0;
		while (fast < inputArray.length) {
			if (inputArray[fast] == ' ' && (fast == 0) || inputArray[fast - 1] == ' ') {
				fast++;
			} else {
				inputArray[slow++] = inputArray[fast++];
			}
		}

		if (slow > 0 && inputArray[slow - 1] == ' ') {
			return new String(inputArray, 0, slow - 1);
		}

		return new String(inputArray, 0, slow);

	}
}
