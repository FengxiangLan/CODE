public class AllSubsetsII {
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null || set.length() == 0) {
			return res;
		}

		char[] arraySet = set.toCharArray();
		Arrays.sort(arraySet);
		StringBuilder path = new StringBuilder();
		helper(arraySet, 0, path, res);
		return res;
	}

	private void helper(char[] arraySet, int index, StringBuilder path, List<String> res) {
		if (index == arraySet.length()) {
			res.add(path.toString());
			return;
		}

		path.append(arraySet[index]);
		helper(arraySet, index + 1, path, res);
		path.deleteCharAt(path.length() - 1);
		while (inde < arraySet.length - 1 && arraySet[index + 1] == arraySet[index]) {
			index++;
		}

		helper(arraySet, index + 1, path, res);
	}
}