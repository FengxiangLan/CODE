public class SpiralOrderTraverse {
	 public List<Integer> spiral(int[][] matrix) {
	 	List<Integer> res = new ArrayList<>();
	 	helper(matrix, 0, matrix.length, res);
	 	return res;
	 }

	 private void helper(int[][] matrix, int start, int size, List<Integer> res) {
	 	if (size <= 1) {
	 		if (size == 1) {
	 			res.add(matrix[start][start]);
	 			return;
	 		} else {
	 			return;
	 		}
	 	}

	 	// top-left to top-right
	 	for (int i = 0; i < size - 1; i++) {
	 		res.add(matrix[start][start + i]);
	 	}

	 	// top-right to bottom-right
	 	for (int i = 0; i < size - 1; i++) {
	 		res.add(matrix[start + i][start + size - 1]);
	 	}

	 	// bottom-right to bottom-left
	 	for (int i = size - 1; i > 0; i--) {
	 		res.add(matrix[start + size - 1][start + i])
	 	}

	 	// bottom-left to top-left
	 	for (int i = size - 1; i > 0; i--) {
	 		res.add(matrix[start + i][start]);
	 	}

	 	helper(matrix, start + 1, size - 2, res);
	 }
}