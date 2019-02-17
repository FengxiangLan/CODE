public class MinHeap {
	// data structure
	private int[] array;
	private int size;

	// constructor function
	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}

		this.array = array;
		this.size = array.length;
		heapify();
	}

	public MinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity can not be non-positive");
		}
		array = new int[cap];
		size = 0;
	}

	private void heapify() {
		// because parentIndex = (childIndex - 1 ) / 2
		// for last child, it's parent is size / 2 - 1;
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == array.length;
	}

	public void percolateUp(int index) {
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (array[parentIndex] > array[index]) {
				swap(array, parentIndex, index);
			} else {
				break;
			}
			index = parentIndex;
		}
	}

	private void percolateDown(int index) {
		while (index <= size / 2 - 1) {
			int leftChildIndex = index * 2 + 1;
			int rightChildIndex = index * 2 + 2;
			int swapIndex = leftChildIndex;
			if (rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
				swapIndex = rightChildIndex;
			}

			if (array[index] > array[swapIndex]) {
				swap(array, index, swapIndex);
			}

			index = swapIndex;
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];
	}

	public int poll() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		int res = array[0];
		array[0] = array[size - 1];
		percolateDown(0);
		return res;
	}

	public void offer(int ele) {
		if (size == array.length) {
			int[] newArray = new int[array.length * 1.5];
			copy(array, newArray);
			array = newArray;
		}
		array[size] = ele;
		size++;
		percolateUp(size - 1);
	}

	public int update(int index, int newEle) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}

		int oldEle = array[index];
		array[index] = newEle;
		if (oldEle > newEle) {
			percolateUp(index);
		} else {
			percolateDown(index);
		}

		return oldEle;
	}
}