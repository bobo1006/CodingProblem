import java.io.*;
import java.util.*;

public class Main {

    static int N,H;
    static int[][] map;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1]; // 방향 정보를 저장

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 2;   // 2 : right
            map[a][b+1] = 1; // 1 : left
        }
        for (int i=0;i<=3;i++){
            backTracking(0,1, i);
        }

        System.out.println(-1);
    }

    private static void backTracking(int cnt, int idxH, int limit){
        if (limit == cnt){
            if (checkGoal()){
                System.out.println(cnt);
                System.exit(0);
            }
            return;
        }

        for (int i=idxH;i<=H;i++){
            for (int j=1;j<N;j++){
                if (map[i][j] != 0 || map[i][j+1] != 0) continue;

                map[i][j] = 2;
                map[i][j+1] = 1;
                backTracking(cnt+1, idxH, limit);
                map[i][j] = 0;
                map[i][j+1] = 0;
            }
        }
    }
    private static boolean checkGoal(){

        for(int i=1;i<=N;i++){
            int num = i;

            for (int j=1;j<=H;j++){
                if (map[j][num] == 1){
                    num--;
                }
                else if (map[j][num] == 2){
                    num++;
                }
            }
            if (num != i) return false;
        }
        return true;
    }
}