import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            int ans = dynamic(n);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
    public static int dynamic(int n){
        int[][] dp = new int[n+1][4];

        for (int i=0;i<=3;i++){
            dp[0][i] = 1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=3;j++){
                if (i-j < 0){
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-j][j];
            }
        }
        return dp[n][3];
    }
}