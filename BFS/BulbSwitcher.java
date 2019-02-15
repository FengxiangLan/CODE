public class BulbSwitcher {
	public int bulbSwitch(int n) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			int numSwitch = helper(i);
			if (numSwitch % 2 == 1) {
				cnt++;
			}
		}
		return cnt;
	}

	private int helper(int n) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				cnt++;
			}
		}
		return cnt;
	}
}