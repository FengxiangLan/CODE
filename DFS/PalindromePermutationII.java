public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}
		Map<Character, Integer> hashMap = HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer k = hashMap.get(c);
			if (k == null) {
				hashMap.put(c, 1);
			} else {
				hashMap.put(c, k + 1);
			}
		}

		int cnt = 0;
		String center = null;
		List<Character> half = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			if (val % 2 == 1) {
				cnt++;
				center = key + '';
			}
			for (int i = 0; i < val / 2; i++) {
				half.add(key);
			}
		}

		if (cnt > 1) {
			return res;
		}

		String mid = center == null ? "" : center;
		StringBuilder path = new StringBuilder();
		boolean[] visited = new boolean[half.size()];
		helper(list, mid, path, visited, path);
		return res; 
	}

	private void helper(List<Character> list, String mid, StringBuilder path, boolean[] visited, List<String> res) {
		if (path.length() == list.size()) {
			String newStr = path.toString() + mid + path.reverse().toString();
			res.add(newStr);
			path.reverse();
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i) == list.get(i - 1) && ! visited[i - 1]) {
				continue;
			}

			if (!visited[i]) {
				visited[i] = true;
				path.append(list.get(i));
				helper(list, mid. path, visited, res);
				path.deleteCharAt(path.length() - 1);
				visited[i] = false;
			}
		}
	}
}