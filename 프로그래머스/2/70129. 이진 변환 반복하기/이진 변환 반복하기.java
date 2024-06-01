class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int strSize = s.length();
            int removedZero = strSize - s.replaceAll("0", "").length();
            
            s = Integer.toBinaryString(strSize - removedZero);
            
            answer[0]++;
            answer[1] += removedZero;
        }
        
        return answer;
    }
}