import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int n, long left, long right) {
		int[] arr = new int[(int) (right - left + 1)];
		int count = 0;
		for (long i = left; i <= right; i++, count++) {
			arr[count] = getValue(n, i);
		}
		return arr;
	}

	private int getValue(int n, long index) {
		long row = index / n + 1;
		long col = index % n + 1;
		return (int) Math.max(row, col);
	}
}