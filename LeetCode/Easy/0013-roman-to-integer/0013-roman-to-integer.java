class Solution {
    public int romanToInt(String s) {
        int answer = 0;

        Map<Character, Integer> converter = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (i == str.length - 1) {
                answer += converter.get(str[i]);
            } else if (str[i] == 'C' && str[i+1] == 'D') {
                answer += 400;
                i++;
            } else if (str[i] == 'C' && str[i+1] == 'M') {
                answer += 900;
                i++;
            } else if (str[i] == 'X' && str[i+1] == 'L') {
                answer += 40;
                i++;
            } else if (str[i] == 'X' && str[i+1] == 'C') {
                answer += 90;
                i++;
            } else if (str[i] == 'I' && str[i+1] == 'V') {
                answer += 4;
                i++;
            } else if (str[i] == 'I' && str[i+1] == 'X') {
                answer += 9;
                i++;
            } else {
                answer += converter.get(str[i]);
            }
        }

        return answer;
    }
}