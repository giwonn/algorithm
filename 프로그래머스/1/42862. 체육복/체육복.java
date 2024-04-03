import java.util.HashMap;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=1; i<=n; i++) {
            map.put(i, 1);
        }
        map.put(0, 0);
        map.put(n+1, 0);

        for (int i: lost) {
            map.replace(i, map.get(i)-1);
        }
        for (int i: reserve) {
            map.replace(i, map.get(i)+1);
        }

        for (int i=1; i<=n; i++) {
            if (map.get(i) == 0) {
                if (map.get(i-1) == 2) {    // 앞번호에게 먼저 빌려보고
                    map.replace(i, 1);
                    map.replace(i-1, 1);
                } else if (map.get(i+1) == 2) { // 앞번호가 없으면 뒷번호에게 빌린다.
                    map.replace(i, 1);
                    map.replace(i+1, 1);
                }
            }
        }

        for (int i: map.values()) {
            if (i > 0) {
                answer++;
            }
        }

        return answer;
    }
}