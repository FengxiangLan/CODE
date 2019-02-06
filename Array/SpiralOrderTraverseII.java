public class SpiralOrderTraverseII {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
	 	helper(matrix, 0, 0, matrix.length, matrix[0].length, res);
	 	return res;
	}

	private void helper(int[][] matrix, int rowIndex, int colIndex, int rowSize, int colSize, List<Integer> res) {
		if (rowSize <= 0 || colSize <= 0) {
			return;
		}

		if (rowSize == 1 && colSize == 1) {
			res.add(matrix[rowIndex][colIndex]);
			return;
		}

		// top left to right
		for (int i = 0; i < colSize - 1; i++) {
			res.add(matrix[rowIndex][colIndex++]);
		}

		// right top to bottom
		for (int i = 0; i < rowSize - 1; i++) {
			res.add(matrix[rowIndex++][colIndex]);
		}

		// bottom right to left
		if (rowSize > 1) {
			for (int i = 0; i < colSize - 1; i++) {
				res.add(matrix[rowIndex][colIndex--]);
			}
		}

		// left bottom to top
		if (colSize > 1) {
			for (int i = 0; i < rowSize - 1; i++) {
				res.add(matrix[rowIndex--][colIndex]);
			}
		}

		if (rowSize == 1 || colSize == 1) {
			helper(matrix, rowIndex, colIndex, 1, 1, res);
		}
		else {
			helper(matrix, rowIndex + 1, colIndex + 1, rowSize - 2, colSize - 2, res);
		}
	} 
}