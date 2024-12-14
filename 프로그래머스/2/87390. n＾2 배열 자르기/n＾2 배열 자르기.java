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
        // n = 4일 때, 1~4는 1, 5~8은 2, 9~12는 3, 13~16은 4
        // rowFirst가 row의 최소값이다.
		long rowFirst = index / n + 1;
        // 첫번째 컬럼은 1, 두번째는 2, 세번째는 3, ...
		long col = index % n + 1;
        
        // index에 해당하는 배열의 값은 최소값이거나 인덱스에 해당하는 값임
		return (int) Math.max(rowFirst, col);
	}
}