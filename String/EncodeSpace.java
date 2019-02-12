public class EncodeSpace {
	public String encode(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}

		char[] inputArray = input.toCharArray();
		StringBuilder newStr = new StringBuilder();
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] != ' ') {
				newStr.append(inputArray[i]);
			} else {
				newStr.append('2');
				newStr.append('0');
				newStr.append('%');
			}
		}
		return newStr.toString();
	}
}