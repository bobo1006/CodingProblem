import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<3;i++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            int total = 0;

            for (int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
                total += arr[j][0] * arr[j][1];
            }
            if (check(arr,total)) sb.append(1);
            else sb.append(0);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static boolean check(int[][] arr, int total){
        if (total%2 == 1) return false;

        total /= 2;
        boolean[] dp = new boolean[total+1];
        
        dp[0] = true;
        for (int i=0;i<arr.length;i++){
            for (int j=total;j>=arr[i][0];j--){
                if (!dp[j - arr[i][0]]) continue;
                for (int k=0;k<=arr[i][1];k++){
                    if (j + arr[i][0] * k > total) break;
                    dp[j + arr[i][0] * k] = true;
                }
            }
        }
        return dp[total];
    }
}