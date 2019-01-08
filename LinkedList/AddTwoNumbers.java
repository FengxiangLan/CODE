public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode nodeL1 = l1;
		ListNode nodeL2 = l2;
		ListNode sum = new ListNode(0);
		ListNode nodeSum = sum;

		int carry = 0;
		while (nodeL1 != null || nodeL2 != null || carry != 0) {
			int x = (nodeL1 != null) ? nodeL1.value : 0;
			int y = (nodeL2 != null) ? nodeL2.value : 0;

			int sum = x + y + carry;

			if (sum >= 10) {
				carry = sum / 10;
			}
			else {
				carry = 0;
			}

			sum = sum % 10;
			ListNode newNode = new ListNode(sum);
			nodeSum.next = newNode;
			nodeSum = nodeSum.next;

			if (nodeL1 != null) {
				nodeL1 = nodeL1.next;
			}

			if (nodeL2 != null) {
				nodeL2 = nodeL2.next;
		}
		return sum.next;
	}
}