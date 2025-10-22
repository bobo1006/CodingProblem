import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x, y;
        int dist;

        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static char[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] dist;
    static int w, h;
    static final int INF = 10000000;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            Point[] node = new Point[11];
            int idx = 1;
            ans = Integer.MAX_VALUE;
            map = new char[h][w];

            for (int i=0;i<h;i++){
                String line = br.readLine();
                for (int j=0;j<w;j++){
                    map[i][j] = line.charAt(j);

                    if (map[i][j] == 'o'){
                        node[0] = new Point(i, j, 0);
                    }
                    else if (map[i][j] == '*'){
                        node[idx++] = new Point(i, j, 0);
                    }
                }
            }

            dist = new int[idx][idx];

            for (int i=0;i<idx;i++){
                for (int j=0;j<idx;j++){
                    if (dist[i][j] == 0) {
                        getDist(i, j, node[i], node[j]);
                    }
                }
            }

            if (ans == -1){
                sb.append(-1).append('\n');
                continue;
            }

            dfs(0, 0, 0, idx, new boolean[idx]);
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    public static void getDist(int startNum, int endNum, Point start, Point end){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];

        visited[start.x][start.y] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            Point now = queue.poll();

            if (now.x == end.x && now.y == end.y){
                dist[startNum][endNum] = now.dist;
                dist[endNum][startNum] = now.dist;
                return;
            }
            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) continue;
                if (visited[nextX][nextY]) continue;
                if (map[nextX][nextY] == 'x') continue;
                
                visited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY, now.dist + 1));
            }
        }

        ans = -1;
        dist[startNum][endNum] = INF;
        dist[endNum][startNum] = INF;
    }

    public static void dfs(int cnt, int now, int depth, int limit, boolean[] visited){
        if (ans <= cnt) return;

        if (depth == limit - 1){
            ans = cnt;
            return;
        }

        for (int i=1;i<limit;i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(cnt + dist[now][i], i, depth + 1, limit, visited);
                visited[i] = false;
            }
        }
    }
}
