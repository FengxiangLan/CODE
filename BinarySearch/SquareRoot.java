public class SquareRoot {
	public int sqrt(int x) {
		int left = 1;
		int right = x;
		int res = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if ((mid == x / mid)){
				return mid;
			}
			if (mid < (x / mid)) {
				left = mid + 1;
				res = mid;
				
			}
			else {
				right = mid - 1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int x = 1000001;
		SquareRoot solution = new SquareRoot();
		int res = solution.sqrt(x);
		System.out.println(res);
	}
}