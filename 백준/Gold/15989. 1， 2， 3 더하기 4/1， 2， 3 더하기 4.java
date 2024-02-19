import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int max = 0;
        int[] arrN = new int[T];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            arrN[i] = Integer.parseInt(br.readLine());
            max = Math.max(arrN[i], max);
        }
        int[][] dp = new int[max + 1][4];

        for (int i = 0; i <= 3; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j < 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - j][j];
            }
        }
        for (int i=0;i<T;i++){
            sb.append(dp[arrN[i]][3]).append('\n');
        }
        System.out.println(sb);
    }
}