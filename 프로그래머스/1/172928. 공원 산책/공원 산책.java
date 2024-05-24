import java.util.Map;

class Solution {
    
    Map<String, Integer> dRow = Map.of("E",0, "W",0, "S",1, "N",-1);
    Map<String, Integer> dCol = Map.of("E",1, "W",-1, "S",0, "N",0);
    
    public int[] solution(String[] park, String[] routes) {
        int rowMax = park.length;
        int colMax = park[0].length();
        
        int[] current = getStartCoordinate(park);
        
        for (String routeStr : routes) {
            move(current, routeStr, park);
        }
        
        return current;
    }
    
    private int[] getStartCoordinate(String[] park) {
        int rowMax = park.length;
        for (int row = 0; row < rowMax; row++) {
            int col = park[row].indexOf('S');
            if (col != -1) {
                return new int[]{ row, col };
            }
        }
        return null;
    }
    
    private void move(int[] current, String routeStr, String[] park) {
        String[] route = routeStr.split(" ");
        int rowDirection = dRow.get(route[0]);
        int colDirection = dCol.get(route[0]);

        int distance = Integer.parseInt(route[1]);
        
        int movedRow = current[0] + rowDirection * distance;
        if (movedRow < 0 || movedRow >= park.length) return;
        
        int movedCol = current[1] + colDirection * distance;
        if (movedCol < 0 || movedCol >= park[movedRow].length()) return;
        
        for (int i=1; i<=distance; i++) {
            int row = current[0] + (rowDirection * i);
            int col = current[1] + (colDirection * i);
            if (park[row].charAt(col) == 'X') return;
        }
        
        current[0] = movedRow;
        current[1] = movedCol;
    }
}
