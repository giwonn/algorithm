class Solution {
    boolean solution(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (count < 0) return false;
            if (c == '(') count++;
            if (c == ')') count--;
        }

        return count == 0;
    }
}