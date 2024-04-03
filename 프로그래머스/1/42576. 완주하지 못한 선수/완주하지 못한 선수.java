import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;


class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = Arrays.stream(participants)
            .collect(
                Collectors.toMap(
                    key -> key,
                    value -> 1,
                    Integer::sum
                )
            );
        
        for (String completion: completions) {
            map.put(completion, map.get(completion) - 1);
        }
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}