public class ValidParenthese {
	public boolean isValid(String input) {
		if (input == null) {
			return true;
		}

		Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			char par = input.charAt(i);
			if (par == '(' || par == '[' || par == '{') {
				stack.offerFirst(par);
			} else {
				char top = stack.isEmpty() ? '?' : stack.pollFirst();
				char rightChar = hashMap.get(par) == null ? '#' : hashMap.get(par);
				if (top != rightChar) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}