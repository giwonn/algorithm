class Solution {
    public int[] solution(String s) {
        
        int loopCount = 0;
        int removedZeroCount = 0;
        
        while(!s.equals("1")) {
            int strSize = s.length();
            
            int removedZero = strSize - s.replaceAll("0", "").length();
            s = Integer.toBinaryString(strSize - removedZero);
            
            removedZeroCount += removedZero;
            loopCount++;
        }
        
        return new int[]{loopCount, removedZeroCount};
    }
}