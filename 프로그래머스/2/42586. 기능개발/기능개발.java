import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil(
                (double) (100 - progresses[i]) / speeds[i]
            );
            days.add(day);
        }
        
        int count = 1;
        int day = days.remove();
        
        List<Integer> answer = new ArrayList<>();
        while(days.size() > 0) {
            int current = days.remove();
            if (current <= day) {
                count++;
            } else {
                day = current;
                answer.add(count);
                count = 1;
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}