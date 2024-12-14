
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num: scoville) {
            priorityQueue.offer(num);
        }
        
        
        
        int count = 0;
        
        while(priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) {
                return -1;
            }
            priorityQueue.offer(priorityQueue.poll() + (priorityQueue.poll() * 2));
            count++;
        }
        
        
        return count;
    }
}