import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {

        int[][] dp = new int[money.length+1][n+1];
        Arrays.sort(money);

        for (int i=1;i< money.length+1;i++){
            dp[i][0] = 1;
        }

        for (int i=1;i<=n;i++){
            for (int j=1;j<=money.length;j++){
                int m = money[j-1];
                dp[j][i] = dp[j-1][i];

                if (i-m >= 0){
                    dp[j][i] += dp[j][i-m];
                }
                dp[j][i] %= 1000000007;
            }
        }
        int answer = dp[money.length][n];
        return answer;
    }
}