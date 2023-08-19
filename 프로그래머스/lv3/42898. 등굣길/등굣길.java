import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        boolean[][] map = new boolean[m+1][n+1];
        
        for (int[] temp : puddles){
            map[temp[0]][temp[1]] = true;
        }

        dp[1][1] = 1;

        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (i==1 && j==1){
                    continue;
                }
                if (map[i][j]){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        int answer = dp[m][n];
        return answer;
    }
}