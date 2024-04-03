import java.util.Collections;
import java.util.PriorityQueue;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        //우선순위가 높은 숫자순으로 정렬(reverseOrder)

        //정렬
        for(int pri : priorities) {
            pq.add(pri);
            System.out.println(pq);
        }

        while(pq.size() != 0) {
            for(int i = 0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) { //맨 앞에있는수 빼버리기(null인지 확인)
                    pq.poll();
                    answer++;
                    if(location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }
}