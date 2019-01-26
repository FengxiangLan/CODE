public class ClosestNumberInBSTII {
	public int[] closestKValues(TreeNode root, double target, int k) {
		PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(k, new Comparator<Double>(){
			@Override
			public int compare(Double x, Double y) {
				if (x == y) {
					return 0;
				}

				return x > y ? -1 : 1;
			}
		});

		Set<Integer> helper = new HashSet<>();

		helper(root, target, k, maxHeap, helper);

		List<Integer> temp = new ArrayList<Integer>(helper);
	    int[] res = new int[temp.size()];
	    for (int i = 0; i < res.length; i++) {
	      res[i] = temp.get(i);
	    }
	    return res;
	}

	private void helper(TreeNode root, double target, int k, PriorityQueue<Double> maxHeap, Set<Integer> helper) {
		if (root == null) {
			return;
		}

		double diff = Math.abs(root.key - target);
		if (maxHeap.size() < k) {
			maxHeap.offer(diff);
			helper.add(root.key);
		} else if (maxHeap.peek() > diff) {
			double x = maxHeap.poll();
			if (!helper.remove((int)(x + target))) {
				helper.remove((int)(target - x));
			}
			maxHeap.offer(diff);
			helper.add(root.key);
		} else {
			if (root.key > target) {
				helper(root.left, target, k, maxHeap, helper);
			} else {
				helper(root.right, target, k, maxHeap, helper);
			}
			return;
		}
		helper(root.left, target, k, maxHeap, helper);
		helper(root.right, target, k, maxHeap, helper);
	}
}