public class DiffElementsInTwoSortedArray {
	public int[][] diff(int[] a, int[] b) {
		List<Integer> aDiff = new ArrayList<>();
		List<Integer> bDiff = new ArrayList<>();
		int i = 0; 
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				aDiff.add(a[i]);
				i++;
				} 
			else if (a[i] > b[j]){
				bDiff.add(b[j]);
				j++;
			} else {
				i++;
				j++;
			}
		}

		while (i < a.length) {
			aDiff.add(a[i]);
			i++;
		}

		while (j < b.length) {
			bDiff.add(b[j]);
			j++;
		}

		int[][] res = new int[2][];
		res[0] = new int[aDiff.size()];
		res[1] = new int[bDiff.size()];
		for (int k = 0; k < aDiff.size(); k++) {
			res[0][k] = aDiff.get(k);
		}
		for (int u = 0; u < bDiff.size(); u++) {
			res[1][u] = bDiff.get(u);
		}
		return res;
	}
}