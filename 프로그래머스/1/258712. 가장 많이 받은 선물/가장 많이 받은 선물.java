import java.util.Map;
import java.util.HashMap;

// * 선물 지수 = 준 선물 - 받은 선물
// 선물 받는 기준
// 1. 서로에게 선물 횟수가 더 많은 사람
// 2. 서로 선물횟수가 없거나 같다면 선물 지수가 더 높은 사람
// 3. 선물 지수 조차 같다면 다음달에 주고받지 않음 (종결)
class Solution {
    public int solution(String[] friends, String[] gifts) {        
        int[] giftScore = new int[friends.length]; // 선물 지수 담을 배열
        Map<String, Integer> friendsIndex = getFriendsIndex(friends);
        int[][] giveAndTakeCount = new int[friends.length][friends.length];
        
        for (String gift : gifts) {
            String[] fromTo = gift.split(" ");
            int fromIndex = friendsIndex.get(fromTo[0]);
            int toIndex = friendsIndex.get(fromTo[1]);
            
        
            // 선물 주고 받을 때 마다 계산
            giveAndTakeCount[toIndex][fromIndex]--;
            giveAndTakeCount[fromIndex][toIndex]++;
            
            // 선물 지수도 업데이트
            giftScore[fromIndex]++;
            giftScore[toIndex]--;
        }
        
        int[] nextMonthCount = new int[friends.length];
        for (int fromIndex = 0; fromIndex < friends.length; fromIndex++) { // 탐색할 사람
            int[] giveAndTake = giveAndTakeCount[fromIndex]; // 탐색중인 사람의 선물 지수 히스토리
            
            for (int toIndex = 0; toIndex < giveAndTake.length; toIndex++) {
                if (fromIndex == toIndex) continue; // 자기자신과 선물을 주고받지 않으므로 스킵
                if (giveAndTake[toIndex] < 0) continue; // 선물을 줘야 하면 스킵
                
                // 선물을 받아야하면 다음달에 받을 선물+1
                if (giveAndTake[toIndex] > 0) {
                    nextMonthCount[fromIndex]++;
                    continue;
                }
                
                // 선물 주고받은 횟수가 같을 때 선물 지수가 더 높으면 선물O
                if (giveAndTake[toIndex] == 0 && giftScore[fromIndex] > giftScore[toIndex]) { 
                    nextMonthCount[fromIndex]++;
                    continue;
                }
            }
        }
        
        int max = 0;
        for (int count : nextMonthCount) {
            max = max > count ? max : count;
        }
        
        return max;
    }
    
    // friend 인덱스 위치 캐싱
    private Map<String, Integer> getFriendsIndex(String[] friends) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        return map;
    }
}