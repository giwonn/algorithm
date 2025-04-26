import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int target = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray()[1];
        
        int[] trees = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int min = 0;
        int max = Arrays.stream(trees).max().getAsInt();
        
        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            
            for (int treeHeight : trees) {
                if (treeHeight <= mid) continue;
                sum += treeHeight - mid;
            }
            
            if (sum < target) {
                // sum이 target보다 작다는 것은 할당량을 못채웠다는 것...
                // 나무를 자르는 위치가 높다는 의미이므로 나무를 더 낮게 잘라야함
                max = mid;
            } else {
                // 필요한 만큼만 자르기 위해서 min을 mid보다 높게 설정
                min = mid + 1;
            }
        }
        
        System.out.println(min - 1);
    }
}