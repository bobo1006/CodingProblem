import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] dist = new int[V+1][V+1];
        final int INF = 10000001;
        for (int i=1;i<=V;i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[s][e] = v;
        }

        for (int k=1;k<=V;k++){
            for (int i=1;i<=V;i++){
                for (int j=1;j<=V;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int min = INF;

        for (int i=1;i<=V;i++){
            for (int j=1;j<=V;j++){
                if (i == j) continue;
                if (dist[i][j] != INF && dist[j][i] != INF) min = Math.min(min, dist[i][j] + dist[j][i]);
            }
        }
        if (min == INF) min = -1;
        System.out.println(min);

    }
}