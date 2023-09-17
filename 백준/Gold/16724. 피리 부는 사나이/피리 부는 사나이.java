import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[][] zone;
    static int N;
    static int M;
    static int cnt = 0;
    static int safeZone = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        zone = new int[N][M];

        for (int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]){
                    safeZone++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(cnt);

    }

    private static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x,y));
        zone[x][y] = safeZone;
        cnt++;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            int[] temp = move(map[now.x][now.y]);
            int nextX = now.x + temp[0];
            int nextY = now.y + temp[1];

            if (!visited[nextX][nextY]){
                queue.add(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                zone[nextX][nextY] = safeZone;
            }
            else if (zone[nextX][nextY] != safeZone){
                cnt--;
            }

        }
    }

    private static int[] move(char c){
        int[] temp;
        if (c == 'U'){
            temp = new int[]{-1,0};
        }
        else if (c == 'D'){
            temp = new int[]{1,0};
        }
        else if (c == 'L'){
            temp = new int[]{0,-1};
        }
        else{
            temp = new int[]{0,1};
        }

        return temp;
    }
}