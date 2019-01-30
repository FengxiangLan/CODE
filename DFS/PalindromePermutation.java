public class PalindromePermutation {
	public boolean canPermutePalindrome(String input) {
		if (input == null || input.length() == 0) {
			return true;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			Integer cnt = map.get(c);
			if (cnt == null) {
				map.put(c, 1);
			}
			else {
				map.put(c, cnt + 1);
			}
		}

		int oddCnt = 0;
		for (Character c : map.keySet()) {
			if (map.get(c) % 2 == 1) {
				oddCnt++;
			}
		}

		return oddCnt <= 1;
	}
}