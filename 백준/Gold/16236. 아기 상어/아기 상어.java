import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int sec;
        Point(int x, int y, int sec){
            this.x = x;
            this.y = y;
            this.sec = sec;
        }
        @Override
        public int compareTo(Point o){
            if (this.sec == o.sec){
                if (this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }
            return this.sec - o.sec;
        }
    }
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int[][] map;
    static int N, size = 2;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Point shark = null;

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){
                    shark = new Point(i,j,0);
                    map[i][j] = 0;
                }
            }
        }

        while (true){
            Point nextShark = bfs(shark);
            if (shark.x == nextShark.x && shark.y == nextShark.y){
                System.out.println(shark.sec);
                break;
            }
            shark = nextShark;
        }
    }

    private static Point bfs(Point shark){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(shark);
        boolean[][] visited = new boolean[N][N];
        visited[shark.x][shark.y] = true;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            if (map[now.x][now.y] != 0 && map[now.x][now.y] < size){
                cnt++;
                map[now.x][now.y] = 0;
                if (cnt == size){
                    size++;
                    cnt = 0;
                }
                return now;
            }
            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (!visited[nextX][nextY] && map[nextX][nextY] <= size){
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY, now.sec+1));
                }
            }
        }
        return shark;
    }
}