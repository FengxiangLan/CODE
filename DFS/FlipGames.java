public class FlipGames {
	public List<String> generatePossibleNextMoves(String input) {
		List<String> res = new ArrayList<String>();
		if (input == null || input.size() == 0) {
			return res;
		}

		char[] helper = input.toCharArray()

		for (int i = 0; i < helper.length - 1; i++) {
			if (helper[i] == '+' && helper[i + 1] == '+') {
				helper[i] = '-';
				helper[i + 1] = '-';
				res.add(String.valueOf(helper));
				helper[i] = '+';
				helper[i + 1] = '+';
			}
		}

		return res;
	}
}