import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int num = 1;
        char[] arr = String.valueOf(num).toCharArray();
        int idx = 0;

        for (int i=0;i<s.length();i++) {
            char now = s.charAt(i);

            if (arr.length == idx){
                num++;
                arr = String.valueOf(num).toCharArray();
                idx = 0;
            }

            while (arr[idx] != now){
                idx++;
                if (arr.length == idx){
                    num++;
                    arr = String.valueOf(num).toCharArray();
                    idx = 0;
                }
            }
            idx++;
        }
        System.out.println(num);
    }
}