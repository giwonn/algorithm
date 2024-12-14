class Solution {
    public int solution(int k, int[][] dungeons) {
        return dfs(dungeons, new boolean[dungeons.length], k, 0, dungeons.length);
    }
    
    public int dfs(
        int[][] dungeons,
        boolean[] checks,
        int k,
        int count,
        int max
    ) {
        if (count == max) return max;
        
        int result = count;
        
        for (int i=0; i<max; i++) {
            if (checks[i] || dungeons[i][0] > k) continue;
            
            checks[i] = true;
            result = Math.max(result, dfs(dungeons, checks, k - dungeons[i][1], count+1, max));
            checks[i] = false;
        }
        
        return result;
    }
}