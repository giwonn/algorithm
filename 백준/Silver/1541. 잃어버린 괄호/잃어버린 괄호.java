import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nums = reader.readLine().split("-");
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            String[] numArr = nums[i].split("\\+");
            int sum = 0;
            
            for (String num: numArr) {
                sum += Integer.parseInt(num);
            }
            
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        
        System.out.println(result);
    }
}