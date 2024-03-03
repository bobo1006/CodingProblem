import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int num = 1;
        int idx = 0;
        String number = String.valueOf(num);
        
        for (int i=0;i<s.length();i++) {
            char now = s.charAt(i);

            if (number.length() == idx){
                num++;
                number = String.valueOf(num);
                idx = 0;
            }

            while (number.charAt(idx) != now){
                idx++;
                if (number.length() == idx){
                    num++;
                    number = String.valueOf(num);
                    idx = 0;
                }
            }
            idx++;
        }
        System.out.println(num);
    }
}