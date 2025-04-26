import java.util.*;

class Solution {
    // 1 <= n <= 1_000_000_000
    // 1 <= times <= 1_000_000_000
    // 1 <= times.length <= 100_000
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 0;
        long right = Arrays.stream(times).max().getAsInt() * (long) n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long completeN = 0;
            
            for (int i = 0; i < times.length; i++) {
                completeN += mid / times[i];
            }
            
            if (completeN < n) { // n명을 심사하는데 시간 mid로는 부족한 경우
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid; // 다음 루프의 mid가 시간을 초과할 경우에 이전 루프의 mid가 최적의 해이기 때문에 미리 저장
            }
        }
        
        return answer;
    }
}