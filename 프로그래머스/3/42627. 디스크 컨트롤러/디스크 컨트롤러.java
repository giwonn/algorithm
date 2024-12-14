import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시간 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 처리시간 순으로 정렬되는 우선순위 큐
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int jobIdx = 0;
        int jobSize = jobs.length;
        int count = 0;
        int endTime = 0;
        
        while (count < jobSize) {
            
            // 작업이 완료되는 시점까지 들어오는 작업을 큐에 추가함
            while (jobIdx < jobSize && jobs[jobIdx][0] <= endTime) {
                queue.add(jobs[jobIdx++]);
            }
             
            
            // 작업이 완료될동안 아무 요청도 안들어올 때
            if (queue.isEmpty()) {
                endTime = jobs[jobIdx][0];
            } 
            // 큐에서 루트 꺼내서 작업함
            else {
                int[] job = queue.poll();
                answer += endTime + job[1] - job[0];
                // 끝난시간 + 수행시간
                endTime += job[1];
                
                // 첫 루프에서 첫 작업을 queue에 담아서 else문으로 들어옴
                // 즉, 큐에서 꺼낸다 = count++로 봐도됨
                count++;
            }
            
        }
        
        return answer / jobSize;
    }
}