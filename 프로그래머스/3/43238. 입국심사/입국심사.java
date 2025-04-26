import java.util.*;

class Solution {
    // 1 <= n <= 1_000_000_000
    // 1 <= times <= 1_000_000_000
    // 1 <= times.length <= 100_000
    public long solution(int n, int[] times) {
        long left = 0;
        long right = Arrays.stream(times).max().getAsInt() * (long) n;
        
        while (left < right) {
            long mid = (left + right) / 2;
            long completeN = 0;
            
            for (int i = 0; i < times.length; i++) {
                completeN += mid / times[i];
            }
            
            if (completeN < n) { // n명을 심사하는데 시간 mid로는 부족한 경우
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return right;
    }
}