import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;
    int time;
    Point(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
class Solution {
    static Point start;
    static Point exit;
    static Point lever;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    boolean[][][] visited; // [][][0]은 레버를 찾기전, [][][1]은 찾은후
    public int solution(String[] maps) {
        char[][] maze = new char[maps.length][maps[0].length()];
        visited = new boolean[maze.length][maze[0].length][2];

        for (int i=0;i< maps.length;i++){
            maze[i] = maps[i].toCharArray();
        }
        find(maze);
        int answer = bfs(maze);
        return answer;
    }

    private void find(char[][] maze){
        for (int i=0;i< maze.length;i++){
            for (int j=0;j<maze[i].length;j++){
                if (maze[i][j] == 'S'){
                    start = new Point(i,j,0);
                }
                else if(maze[i][j] == 'E'){
                    exit = new Point(i,j,0);
                }
                else if (maze[i][j] == 'L'){
                    lever = new Point(i,j,0);
                }
            }
        }
    }

    private int bfs(char[][] maze){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int idx = 0;
        visited[start.x][start.y][idx] = true;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            if (idx == 0){
                if (lever.x == now.x && lever.y == now.y){
                    idx++;
                    queue.clear();
                    queue.add(new Point(now.x, now.y, now.time + 1));
                    visited[lever.x][lever.y][idx] = true;
                }
            }
            else if (idx == 1){
                if (exit.x == now.x && exit.y == now.y){
                    return now.time;
                }
            }

            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (0 <= nextX && nextX < maze.length && 0 <= nextY && nextY < maze[0].length){
                    if (!visited[nextX][nextY][idx] && maze[nextX][nextY] != 'X'){
                        visited[nextX][nextY][idx] = true;
                        queue.add(new Point(nextX, nextY, now.time + 1));
                    }
                }
            }
        }
        return -1;
    }
}