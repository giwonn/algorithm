import java.util.Map;

class Solution {
    
    Map<String, Integer> dRow = Map.of("E",0, "W",0, "S",1, "N",-1);
    Map<String, Integer> dCol = Map.of("E",1, "W",-1, "S",0, "N",0);
    
    public int[] solution(String[] park, String[] routes) {
        int[] current = getStartCoordinate(park);
        
        for (String routeStr : routes) {
            move(current, routeStr, park);
        }
        
        return current;
    }
    
    // 시작지점 좌표 탐색
    private int[] getStartCoordinate(String[] park) {
        int rowMax = park.length;
        for (int row = 0; row < park.length; row++) {
            int col = park[row].indexOf('S');
            if (col != -1) return new int[]{ row, col };
        }
        return null;
    }
    
    // 좌표 이동
    private void move(int[] current, String routeStr, String[] park) {
        String[] route = routeStr.split(" ");
        int rowDirection = dRow.get(route[0]);
        int colDirection = dCol.get(route[0]);

        int distance = Integer.parseInt(route[1]);
        
        int movedRow = current[0] + rowDirection * distance;
        // 유효한 row 이동인지 체크
        if (movedRow < 0 || movedRow >= park.length) return;
        
        int movedCol = current[1] + colDirection * distance;
        // 유효한 col 이동인지 체크
        if (movedCol < 0 || movedCol >= park[movedRow].length()) return;
        
        // 한칸씩 이동하면서 장애물에 막히는지 체크
        for (int i=1; i<=distance; i++) {
            int row = current[0] + (rowDirection * i);
            int col = current[1] + (colDirection * i);
            if (park[row].charAt(col) == 'X') return;
        }
        
        // 유효한 이동이고 장애물에도 막히지 않으면 좌표 이동
        current[0] = movedRow;
        current[1] = movedCol;
    }
}
