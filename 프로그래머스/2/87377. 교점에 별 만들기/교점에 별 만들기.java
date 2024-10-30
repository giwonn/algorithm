import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public String[] solution(int[][] line) {
        List<int[]> dots = new ArrayList<>();
        
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                long[] dot = getCrossDot(line[i], line[j]);
                if (dot == null) continue;
                
                dots.add(new int[]{ (int) dot[0], (int) dot[1] });
            }
        }
        
        String[][] answer = getStarArray(dots);

        return Arrays.stream(answer)
            .map(row -> String.join("", row))
            .toArray(String[]::new);
    }
    
    public long[] getCrossDot(int[] a, int[] b) {
        long A = a[0], B = a[1], C = a[2];
        long D = b[0], E = b[1], F = b[2];
        
        long adBc = A*E - B*D;
        if (adBc == 0) return null;
        
        long x = B*F - C*E;
        long y = C*D - A*F;
        
        if (x % adBc != 0 || y % adBc != 0) return null;
        
        return new long[]{ x/adBc, y/adBc };
    }
    
    public boolean isIntegerDot(float[] dot) {
        return dot[0] == (int) dot[0] && dot[1] == (int) dot[1];
    }
    
    public String[][] getStarArray(List<int[]> dots) {
        int maxX = dots.stream().mapToInt(arr -> arr[0]).max().getAsInt();
        int maxY = dots.stream().mapToInt(arr -> arr[1]).max().getAsInt();
        int minX = dots.stream().mapToInt(arr -> arr[0]).min().getAsInt();
        int minY = dots.stream().mapToInt(arr -> arr[1]).min().getAsInt();

        int sizeY = maxY - minY + 1;
        int sizeX = maxX - minX + 1;

        String[][] answer = new String[sizeY][sizeX];

        for (int y = 0; y < sizeY; y++) {
            Arrays.fill(answer[y], ".");
        }

        for (int[] dot: dots) {
            int x = dot[0] - minX;
            int y = maxY - dot[1];
            answer[y][x] = "*";
        }
        
        return answer;
    }
}