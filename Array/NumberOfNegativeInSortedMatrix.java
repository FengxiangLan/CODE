public class NumberOfNegativeInSortedMatrix {
	public int negNumber(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0;
		int j = n - 1;
		int count = 0;
		while (j >= 0 && i < m) {
			if (matrix[i][j] < 0) {
				count += j + 1;
				i += 1;
			} else {
				j--;
			}
		}

		return count;
	}
}