import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N+1];
        int[] cost = new int[N+1];
        int[][] dp;
        int maxCost = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            int temp = Integer.parseInt(st.nextToken());
            cost[i] = temp;
            maxCost += temp;
        }
        int min = Integer.MAX_VALUE;

        dp = new int[N+1][maxCost+1];
        for (int i=0;i<maxCost+1;i++){
            if (cost[1] <= i){
                dp[1][i] = memory[1];
            }
            if (dp[1][i] >= M) min = Math.min(i, min);
        }

        for(int i=2;i<=N;i++) {
            for(int j=0;j<maxCost+1;j++) {
                if(cost[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + memory[i]);
                }
                if (dp[i][j] >= M) min = Math.min(j, min);
            }
        }
        System.out.println(min);
    }
}