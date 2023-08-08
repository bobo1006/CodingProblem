import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point{
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    private int bfs(int[][] map){
        int n = map.length;
        int m = map[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            if (now.x == n-1 && now.y == m-1){
                return now.cnt;
            }
            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (0 <= nextX && 0 <= nextY && nextX < n && nextY < m){
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        queue.add(new Point(nextX,nextY,now.cnt + 1));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }
}