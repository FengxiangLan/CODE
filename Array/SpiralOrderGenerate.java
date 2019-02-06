 public class SpiralOrderGenerateII {
	public int[][] spiralGenerate(int m, int n) {
		int[][] matrix = new int[m][n];
		helper(0, 0, m, n, new int[]{1}, matrix);
		return matrix;
	}

	private void helper(int rowIndex, int colIndex, int rowSize, int colSize, int[] ele, int[][] matrix) {
		if (rowSize <= 0 || colSize <= 0) {
			return;
		}

		if (rowSize == 1 && colSize == 1) {
			matrix[rowIndex][colIndex] = ele[0];
			return;
		}

		for (int i = 0; i < colSize - 1; i++) {
			matrix[rowIndex][colIndex++] = ele[0]++;
		}

		for (int i = 0; i < rowSize - 1; i++) {
			matrix[rowIndex++][colIndex] = ele[0]++;
		}

		if (rowSize > 1) {
			for (int i = 0; i < colSize - 1; i++) {
				matrix[rowIndex][colIndex--] = ele[0]++;
			}
		}

		if (colSize > 1) {
			for (int i = 0; i < rowSize - 1; i++) {
				matrix[rowIndex--][colIndex] = ele[0]++;
			}
		}

		if (rowSize == 1 || colSize == 1) {
			helper(rowIndex, colIndex, 1, 1, ele, matrix);
		}
		else {
			helper(rowIndex + 1, colIndex + 1, rowSize - 2, colSize - 2, ele, matrix);
		}
	}
 }

