class Solution {
    public String decodeString(String s) {
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        StringBuilder str = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                strStack.addLast(str.toString());
                numStack.addLast(num);
                str = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                int preNum = numStack.pollLast();
                String preStr = strStack.pollLast();
                str = new StringBuilder(preStr + str.toString().repeat(preNum));
            } else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                str.append(ch);
            }
        }

        return str.toString();
    }
}