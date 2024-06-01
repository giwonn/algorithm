import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }
       
        List<Integer> expireList = new ArrayList<>();
        int todayTime = getTime(today);
            
        for (int i=0; i<privacies.length; i++) {
            String[] dateAndTerm = privacies[i].split(" ");
            if (getTime(dateAndTerm[0]) + termMap.get(dateAndTerm[1]) * 28 <= getTime(today)) expireList.add(i+1);
        }
        
        int[] answer = new int[expireList.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = expireList.get(i);
        }

        return answer;
    }
    
    private int getTime(String date) {
        String[] dates = date.split("\\.");
        return Integer.parseInt(dates[0]) * 12 * 28
            + Integer.parseInt(dates[1]) * 28
            + Integer.parseInt(dates[2]);
    }
}