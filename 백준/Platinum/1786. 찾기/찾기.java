import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();

        int[] lps = new int[P.length()];
        computeArr(P, lps);
        kmp(T, P, lps);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        for (int ans : list){
            sb.append(ans).append(' ');
        }

        System.out.println(sb);
    }

    public static void computeArr(String s, int[] lps){
        int len = s.length();
        int sameLen = 0;
        int idx = 1;

        while (idx < len){
            if (s.charAt(sameLen) == s.charAt(idx)){
                sameLen++;
                lps[idx] = sameLen;
                idx++;
            }
            else{
                if (sameLen != 0){
                    sameLen = lps[sameLen-1];
                }
                else{
                    lps[idx] = 0;
                    idx++;
                }
            }
        }
    }

    public static void kmp(String T, String P, int[] lps){
        int pIdx = 0;
        int tIdx = 0;


        while (tIdx < T.length()){
            if (T.charAt(tIdx) == P.charAt(pIdx)){
                pIdx++;
                tIdx++;

                if (pIdx == P.length()){
                    cnt++;
                    list.add(tIdx - P.length() + 1);
                    pIdx = lps[pIdx - 1];
                }
            }
            else{
                if (pIdx == 0){
                    tIdx++;
                }
                else{
                    pIdx = lps[pIdx - 1];
                }
            }
        }

    }
}
