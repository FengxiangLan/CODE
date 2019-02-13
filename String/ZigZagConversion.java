public class ZigZagConversion {
	public String convert(String input, int nRows) {
		if (input == null || nRows == 1) {
			return input;
		}

		List<StringBuilder> res = new ArrayList<>();
		for (int i = 0; i < Math.min(input.length(), nRows); i++) {
			res.add(new StringBuilder());
		}

		int curRow = 0;
		boolean down = false;

		for (char c : input.toCharArray()) {
			res.get(curRow).append(c);
			if (curRow == 0 || curRow == nRows - 1) {
				down = !down;
			}
			curRow += down ? 1 : -1; 
		}

		StringBuilder output = new StringBuilder();
		for (StringBuilder s : res) {
			output.append(s);
		}
		return output.toString();
	} 
}