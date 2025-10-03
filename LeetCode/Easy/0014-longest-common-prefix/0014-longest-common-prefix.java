class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        int current = 0;
        while (strs[0].length() > current) {
            char temp = strs[0].charAt(current);
            for (String str : strs) {
                if (str.length() <= current) return sb.toString();
                if (temp != str.charAt(current)) return sb.toString();
            }
            sb.append(temp);
            current++;
        }

        return sb.toString();
    }
}