public class SpiralOrderGenerateII {
	public int[][] spiralGenerate(int n) {
		int[][] matrix = new int[n][n];
		int[] ele = {1};
		helper(0, n, ele, matrix);
		return matrix;
	}

	private void helper(int start, int size, int[] ele, int[][] matrix) {
		if (size <= 1) {
			if (size == 1) {
				matrix[start][start] = ele[0];
				return;
			} else {
				return;
			}
		}

		for (int i = 0; i < size - 1; i++) {
			matrix[start][start + i] = ele[0];
			ele[0]++;
		}

		for (int i = 0; i < size - 1; i++) {
	 		matrix[start + i][start + size - 1] = ele[0];
	 		ele[0]++;
	 	}

	 	for (int i = size - 1; i > 0; i--) {
	 		matrix[start + size - 1][start + i] = ele[0];
	 		ele[0]++;
	 	}

	 	for (int i = size - 1; i > 0; i--) {
	 		matrix[start + i][start] = ele[0];
	 		ele[0]++;
	 	}

	 	helper(start + 1, size - 2, ele, matrix);
	}
}
