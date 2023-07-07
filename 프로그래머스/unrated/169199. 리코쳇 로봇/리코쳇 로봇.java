import java.util.LinkedList;
import java.util.Queue;
class Point{
    int x;
    int y;
    int cntMove;
    Point(int x, int y, int cntMove){
        this.x = x;
        this.y = y;
        this.cntMove = cntMove;
    }
}
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static Point start;
    static Point goal;
    public int solution(String[] board) {

        char[][] map = new char[board.length][board[0].length()];

        for (int i=0;i< board.length;i++){
            map[i] = board[i].toCharArray();
        }

        for (int i=0;i< map.length;i++){
            for (int j=0;j<map[i].length;j++){
                if (map[i][j] == 'R'){
                    start = new Point(i,j,0);
                }
                else if (map[i][j] == 'G'){
                    goal = new Point(i,j,0);
                }
            }
        }

        visited = new boolean[map.length][map[0].length];

        int answer = bfs(map);

        return answer;
    }

    public int bfs(char[][] map){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()){
            Point temp = queue.poll();

            if (temp.x == goal.x && temp.y == goal.y){
                return temp.cntMove;
            }
            for (int i=0;i<4;i++){
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];

                while(!isEdge(nextX, nextY, map)){
                    nextX += dx[i];
                    nextY += dy[i];
                }
                nextX -= dx[i];
                nextY -= dy[i];

                if (!visited[nextX][nextY]){
                    queue.add(new Point(nextX, nextY, temp.cntMove+1));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }

    public boolean isEdge(int i, int j, char[][] map){
        if (0 <= i && i < map.length && 0 <= j && j< map[i].length){
            if (map[i][j] == 'D'){
                return true;
            }
            return false;
        }
        return true;

    }

}