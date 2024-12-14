import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        int answer = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet())
            .size();
        
        return answer < nums.length / 2 ? answer : nums.length / 2;
    }
}