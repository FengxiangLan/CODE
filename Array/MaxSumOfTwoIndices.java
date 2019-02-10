public class MaxSumOfTwoIndices {
	public int[] maxSum(int[] array) {
		int first = 0;
		int second = 0;
		int firstSum = Integer.MIN_VALUE;
		int secondSum = Integer.MIN_VALUE;

	 	for (int i = 0; i < array.length; i++) {
	 		if (array[i] - i >= firstSum) {
	 			first = i;
	 			firstSum = array[i] - i;
	 		}

	 		if (array[i] + i >= secondSum) {
	 			second = i;
	 			secondSum = array[i] + i;
	 		}
	 	}

	 	return first < second ? new int[]{first, second} : new int[]{second, first};
	}
}