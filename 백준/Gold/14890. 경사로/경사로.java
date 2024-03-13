import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i=0;i<N;i++){
            int cnt = 1;
            int pre = map[i][0];
            boolean preHigh = false;
            boolean road = true;
            for (int j=1;j<N;j++){
                if (preHigh && cnt == L){
                    preHigh = false;
                    cnt -= L;
                }

                if(map[i][j] == pre){
                    cnt++;
                }
                else if (map[i][j] > pre){
                    if (map[i][j] - pre != 1 || cnt < L){
                        road = false;
                        break;
                    }
                    cnt = 1;
                    pre = map[i][j];
                    preHigh = false;
                }
                else{
                    if (pre - map[i][j] != 1 || (preHigh && cnt < L)) {
                        road = false;
                        break;
                    }
                    preHigh = true;
                    cnt = 1;
                    pre = map[i][j];
                }
            }
            if (preHigh && cnt < L) continue;
            if (road) ans++;
        }

        for (int i=0;i<N;i++){
            int cnt = 1;
            int pre = map[0][i];
            boolean preHigh = false;
            boolean road = true;
            for (int j=1;j<N;j++){
                if (preHigh && cnt == L){
                    preHigh = false;
                    cnt -= L;
                }
                if(map[j][i] == pre){
                    cnt++;
                }
                else if (map[j][i] > pre){
                    if (map[j][i] - pre != 1 || cnt < L){
                        road = false;
                        break;
                    }
                    cnt = 1;
                    pre = map[j][i];
                }
                else{
                    if (pre - map[j][i] != 1 || (preHigh && cnt < L)) {
                        road = false;
                        break;
                    }
                    preHigh = true;
                    cnt = 1;
                    pre = map[j][i];
                }
            }
            if (preHigh && cnt < L) continue;
            if (road) ans++;
        }

        System.out.println(ans);
    }
}