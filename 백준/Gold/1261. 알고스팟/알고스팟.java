import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
    int x;
    int y;
    int wall;
    Point(int x, int y, int wall){
        this.x = x;
        this.y = y;
        this.wall = wall;
    }
}
class Main {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[M][N];
        int[][] maze = new int[M][N];
        for (int i=0;i<M;i++){
            String s = br.readLine();
            map[i] = s.toCharArray();
            Arrays.fill(maze[i], Integer.MAX_VALUE);
        }
        maze[0][0] = 0;

        System.out.println(bfs(map,maze,N,M));
    }
    private static int bfs(char[][] map, int[][] maze, int N, int M){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0, 0));

        while (!queue.isEmpty()){
            Point now = queue.poll();

            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (map[nextY][nextX] == '0' && maze[nextY][nextX] > now.wall){
                    maze[nextY][nextX] = now.wall;
                    queue.add(new Point(nextX, nextY, now.wall));
                }
                else if (map[nextY][nextX] == '1' && maze[nextY][nextX] > now.wall+1){
                    maze[nextY][nextX] = now.wall+1;
                    queue.add(new Point(nextX,nextY, now.wall+1));
                }
            }
        }
        return maze[M-1][N-1];
    }
}