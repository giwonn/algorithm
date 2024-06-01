import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }
       
        List<Integer> answer = new ArrayList<>();
        int todayTime = getTime(today);
            
        for (int i=0; i<privacies.length; i++) {
            String[] dateAndTerm = privacies[i].split(" ");
            if (getTime(dateAndTerm[0]) + termMap.get(dateAndTerm[1]) * 28 <= todayTime) answer.add(i+1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int getTime(String date) {
        String[] dates = date.split("\\.");
        return Integer.parseInt(dates[0]) * 12 * 28
            + Integer.parseInt(dates[1]) * 28
            + Integer.parseInt(dates[2]);
    }
}