public class CommonNumbersOFTwoSortedArray {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < a.size() && j < b.size()) {
			if (a.get(i) == b.get(j)) {
				res.add(a.get(i));
				i++;
				j++;
			} else {
				if (a.get(i) > b.get(j)) {
					j++;
				} else {
					i++;
				}
			}
		}
		return res;
	}
}