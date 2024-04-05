import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder sb = new StringBuilder();

        while (!s.equals("end")){
            boolean isVowel = false;
            boolean flag = false;
            int cnt = 0;
            char preC = ' ';
            boolean isSafe = true;

            for (int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if (checkSame(preC, c)) {
                    isSafe = false;
                    break;
                }

                if (checkVowel(c, vowel)){
                    isVowel = true;
                    if (!flag) cnt++;
                    else cnt = 1;
                    flag = false;
                }
                else {
                    if (flag) cnt++;
                    else cnt = 1;
                    flag = true;
                }

                if (cnt >= 3){
                    isSafe = false;
                    break;
                }
                preC = c;
            }
            if (!isVowel) isSafe = false;
            if (isSafe) sb.append("<" + s + "> ").append("is acceptable.");
            else sb.append("<" + s + "> ").append("is not acceptable.");
            sb.append('\n');

            s = br.readLine();
        }
        System.out.println(sb);
    }
    private static boolean checkVowel(char c, char[] vowel){
        for (int i=0;i<vowel.length;i++){
            if (c == vowel[i]) return true;
        }
        return false;
    }
    private static boolean checkSame(char c1, char c2){
        if (c1 == c2 && c1 != 'e' && c1 != 'o'){
            return true;
        }
        return false;
    }
}