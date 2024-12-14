import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = Map.of(
            '[', ']',
            '{', '}',
            '(', ')'
        );
        
        int max = s.length();
        for (int i = 0; i < max; i++) {
            
            Stack<Character> openBracketStack = new Stack<>();
            boolean isCorrect = true;
            
            for (int j = i; j < max+i; j++) {
                int idx = j >= max ? j - max : j;
                char bracket = s.charAt(idx);
                
                // [ { ( 중 하나면 stack에 push
                if (map.containsKey(bracket)) {
                    openBracketStack.push(bracket);
                    continue;
                }
                
                // **아래부터는 ] } ) 에 대한 케이스**
                
                // 열린괄호 스택이 비어있으면 안됨
                if (openBracketStack.isEmpty()) {
                    isCorrect = false;
                    break;
                }
                
                // 스택 포인터와 같은 종류의 괄호인지 확인
                if (bracket != map.get(openBracketStack.pop())) {
                    isCorrect = false;
                    break;
                }
            }
            if (!openBracketStack.isEmpty()) {
                isCorrect = false;
            }
            
            if (isCorrect) answer++;
        }
        
        return answer;
    }
}