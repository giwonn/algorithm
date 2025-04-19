import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());
       
        System.out.println(first * (second % 10));
        System.out.println(first * ((second % 100) / 10));
        System.out.println(first * (second / 100));
        System.out.println(first * second);
    }
}