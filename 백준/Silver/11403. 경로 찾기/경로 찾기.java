import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N][N];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=0;k<N;k++){
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if (d[i][k] == 1 && d[k][j] == 1) d[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                sb.append(d[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}