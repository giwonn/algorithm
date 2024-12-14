import java.util.*;

public class Solution {
    public int solution(int n) {
        int moved = 1; // 최초에 1만큼 점프한 상태에서 시작
        
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                moved++;
            }
        }
        
        return moved;
    }
}