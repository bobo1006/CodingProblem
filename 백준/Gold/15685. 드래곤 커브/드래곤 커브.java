import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        boolean[] arr = new boolean[1025];

        for (int i=0;i<10;i++){
            int tmp = (int)Math.pow(2,i);
            arr[tmp + 1] = true;
            for (int j=tmp+2;j<=tmp*2;j++){
                arr[j] = !arr[tmp * 2 - j + 2];
            }
        }
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            map[x][y] = true;
            x += dx[d];
            y += dy[d];
            map[x][y] = true;

            int temp = (int)Math.pow(2,g);
            for (int j=2;j<=temp;j++){
                if(arr[j]){
                    d = (d + 1) % 4;
                }
                else{
                    d = (d + 3) % 4;
                }
                x += dx[d];
                y += dy[d];
                map[x][y] = true;
            }
        }

        System.out.println(find());


    }
    private static int find(){
        int cnt = 0;
        for (int i=0;i<100;i++){
            for (int j=0;j<100;j++){
                if (map[i][j]){
                    if (!map[i+1][j] || !map[i][j+1] || !map[i+1][j+1]) continue;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}