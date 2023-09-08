import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point{
        int x;
        int y;
        int dir;
        int cost;
        Point(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] board) {
        int answer = bfs(board);
        return answer;
    }

    private int bfs(int[][] board){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,2,0));
        int len = board.length;
        int[][][] map = new int[len][len][4];
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            if (now.x == len-1 && now.y == len-1){
                min = Math.min(min, now.cost);
            }
            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                int dir = i<2?0:1;

                if (nextX < 0 || nextY < 0 || nextX >= len || nextY >= len || board[nextX][nextY] == 1) continue;

                int cost = now.cost;
                if (now.dir == dir || now.dir == 2) cost += 100;
                else cost += 600;

                if (map[nextX][nextY][i] > cost || map[nextX][nextY][i] == 0){
                    map[nextX][nextY][i] = cost;
                    queue.add(new Point(nextX, nextY, dir, cost));
                }


            }
        }

        return min;
    }
}