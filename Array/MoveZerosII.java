public class MoveZerosII {
	public int[] moveZero(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}

		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			if (array[fast] != 0) {
				array[slow++] = array[fast++];
			} else {
				fast++;
			}
		}

		while (slow < array.length) {
			array[slow++] = 0;
		}
		return array;
	}
}