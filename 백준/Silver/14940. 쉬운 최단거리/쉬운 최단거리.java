import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static class Point{
        int x;
        int y;
        int dist;
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[] start = {};

        int[][] arrDist = new int[N][M];
        for (int i=0;i<N;i++){
            Arrays.fill(arrDist[i], -1);
        }

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2){
                    start = new int[]{i,j};
                }
                if (num == 0){
                    arrDist[i][j] = 0;
                }
            }
        }

        bfs(map, start, arrDist);
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                sb.append(arrDist[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void bfs(int[][] map, int[] start, int[][] arrDist){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1], 0));
        boolean[][] visited = new boolean[N][M];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){
            Point now = queue.poll();
            arrDist[now.x][now.y] = now.dist;

            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (!visited[nextX][nextY] && map[nextX][nextY] != 0){
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY, now.dist+1));
                }
            }
        }

    }
}