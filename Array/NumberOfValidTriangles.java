public class NumberOfValidTriangles {
	public int numOfTriangles(int[] array) {
		int count = 0;
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < array.length - 1 && array[i] != 0; j++) {
				while (k < array.length && array[i] + array[j] > array[k]) {
					k++;
				}
				count += k - j - 1;
			}
		}
		return count;
	}
}