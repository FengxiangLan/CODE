public class IsomorphicStringI {
	public boolean isomorphic(String source, String target) {
		if (s.length() != t.length()) {
		return false;
		}

		HashSet<Character> valueSet = new HashSet<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		int len = s.length();
		if (t.length() != len) return false;
		for (int i =0 ; i < len; i++) {
			if (map.containsKey(s.charAt(i))) {
				if (t.charAt(i) != map.get(s.charAt(i))) return false;
			}
			else {
				if (valueSet.contains(t.charAt(i))) return false;
				map.put(s.charAt(i), t.charAt(i));
				valueSet.add(t.charAt(i));
			}
		}

		return true;
	}
}