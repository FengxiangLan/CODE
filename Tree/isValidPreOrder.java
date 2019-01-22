public class isValidPreOrder {
	public boolean isValidSerialization(String preorder) {
		String[] preOrder = preorder.split(",");
		int diff = 0;
		for (int i = 0; i < preOrder.length - 1; i++) {
			if (preOrder[i].equals("#")) {
				if (diff == 0) {
					return false
				}
				diff--;
			}
			else {
				diff++;
			}
		}
		return diff == 0 && preOrder[preOrder.length - 1] .equals("#");
	}
}
