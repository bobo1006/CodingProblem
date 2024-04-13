import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Integer.MAX_VALUE;

        int[][] dp = new int[N][3];
        for (int color=0;color<3;color++){
            for (int i=0;i<3;i++){
                if (color != i) dp[0][i] = 2000;
                else dp[0][i] = arr[0][i];
            }
            for (int i=1;i<N;i++){
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }

            for (int i=0;i<3;i++){
                if (color == i) continue;
                min = Math.min(dp[N-1][i], min);
            }
        }
        System.out.println(min);

    }

}