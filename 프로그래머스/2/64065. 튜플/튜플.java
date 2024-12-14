import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] strArr = s.substring(2, s.length() - 2).split("\\},\\{");
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String str : strArr) {
            String[] tuple = str.split(",");
            for (String num : tuple) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> map.get(s2) - map.get(s1));
        
        int[] answer = new int[keyList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(keyList.get(i));
        }
        
        return answer;
    }
}