import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int N,M;
    static ArrayList<Point> disableVirus = new ArrayList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int min = Integer.MAX_VALUE;
    static int empty = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2){
                    disableVirus.add(new Point(i,j));
                }
                else if (map[i][j] == 0){
                    empty++;
                }
            }
        }

        Point[] virus = new Point[M];
        if (empty == 0){
            min = 0;
            System.out.println(min);
        }
        else{
            dfs(0, 0, virus);
            if (min == Integer.MAX_VALUE) min = -1;
            System.out.println(min);
        }

    }
    private static void dfs(int depth, int index, Point[] virus){
        if (depth == M){
            min = Math.min(bfs(virus), min);
            return;
        }
        for (int i=index;i< disableVirus.size();i++){

            virus[depth] = disableVirus.get(i);
            dfs(depth + 1, i+1, virus);

        }

    }
    private static int bfs(Point[] virus){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i=0;i<M;i++){
            queue.add(virus[i]);
            visited[virus[i].x][virus[i].y] = true;
        }
        int emptyClone = empty;
        int sec = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            sec++;

            for (int i=0;i<size;i++){
                Point now = queue.poll();

                for (int j=0;j<4;j++){
                    int nextX = now.x + dx[j];
                    int nextY = now.y + dy[j];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                    if (visited[nextX][nextY] || map[nextX][nextY] == 1) continue;

                    if (map[nextX][nextY] == 0){
                        emptyClone--;
                    }
                    if (emptyClone == 0){
                        return sec;
                    }
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }

        }

        return Integer.MAX_VALUE;
    }
}