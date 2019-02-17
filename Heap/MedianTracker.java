public class MedianTracker {
	private PriorityQueue<Integer> smallerPart;
	private PriorityQueue<Integer> largerPart;

	public Solution() {
		largerPart = new PriorityQueue<Integer>();
		smallerPart = new PriorityQueue<Integer>(11, Collections.reverseOrder());
	}

	public void read(int value) {
		if (smallerPart.isEmpty() || value <= smallerPart.peek()) {
			smallerPart.offer(value);
		}
		else {
			largerPart.offer(value);
		}

		if (smallerPart.size() - largerPart.size() >= 2) {
			largerPart.offer(smallerPart.poll());
		}
		else if (smallerPart.size() < largerPart.size()) {
			smallerPart.offer(largerPart.poll());
		}
	}

	public Double median() {
		int size = size();
		if (size == 0) {
			return null;
		}
		else if (size % 2 != 0) {
			return (double) (smallerPart.peek());
		}
		else {
			return (smallerPart.peek() + largerPart.peek()) / 2.0;
		}

	}

	private int size() {
		return smallerPart.size() + largerPart.size();
	}
}