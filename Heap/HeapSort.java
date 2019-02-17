public class HeapSort {
	public int[] heapsort(int[] array) {
		int n = array.length;
		for(int i = n / 2 - 1; i >= 0; i--){
			heapify(array, i, n);
		}

		for (int i = n - 1; i >= 0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
 
          	// Heapify root element
            heapify(arr, 0, i);
        }

		return array;
	}

	private void heapify(int[] array, int i, int size) {
		// because parentIndex = (childIndex - 1 ) / 2
		// for last child, it's parent is size / 2 - 1;
		int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2;  
 
        if (l < size && array[l] > array[largest])
            largest = l;
 
        if (r < size && array[r] > array[largest])
            largest = r;
 
      	// Swap and continue heapifying if root is not largest
        if (largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
 
            heapify(array, largest, size);
        }
	}
}