import java.io.*;
import java.util.*;
class Main {

    static class Cleaner{
        int x, y, d;
        Cleaner(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(find(map, N, M, r, c, d));
    }

    public static int find(int[][] map, int N, int M, int r, int c, int d){
        Queue<Cleaner> queue = new LinkedList<>();
        queue.add(new Cleaner(r,c,d));
        int cnt = 0;

        while (!queue.isEmpty()){
            Cleaner now = queue.poll();
            boolean isClean = true;
            int dir = now.d;
            if (map[now.x][now.y] == 0){
                cnt++;
                map[now.x][now.y] = 2;
            }

            for (int i=0;i<4;i++){
                dir = (dir+3)%4;
                int nextX = now.x + dx[dir];
                int nextY = now.y + dy[dir];
                if (map[nextX][nextY] == 0){
                    queue.add(new Cleaner(nextX, nextY, dir));
                    isClean = false;
                    break;
                }
            }

            if (isClean){
                dir = (now.d+2)%4;
                int nextX = now.x + dx[dir];
                int nextY = now.y + dy[dir];
                if (map[nextX][nextY] == 1) break;
                queue.add(new Cleaner(nextX, nextY, now.d));
            }
        }
        return cnt;
    }
}