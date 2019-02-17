public class TopKFrequentWords {
	public String[] topKFrequent(String[] combo, int k) {
		if (combo.length == 0) {
			return new String[0];
		}

		Map<String, Integer> freqMap = getFreqMap(combo);

		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			}else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}

		return freArray(minHeap);
	}

	private Map<String, Integer> getFreqMap(String[] combo) {
		Map<String, Integer> freqMap = new HashMap<>();
		for (String s : combo) {
			Integer freq = freqMap.get(s);
			if (freq == null) {
				freqMap.put(s, 1);
			}
			else {
				freqMap.put(s, freq + 1);
			}
		}

		return freqMap;
	}

	private String[] freArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		String[] res = new String[minHeap.size()];
		int i = res.length - 1;
		while (!minHeap.isEmpty()) {
			res[i] = minHeap.poll().getKey();
			i--;
		}

		return res;
	}

	
}
