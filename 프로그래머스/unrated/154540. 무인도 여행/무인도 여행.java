import java.util.*;

class Solution {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static boolean[][] visited;

    public ArrayList<Integer> solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j] && maps[i].charAt(j) !='X'){
                    answer.add(bfs(maps, i, j));
                }
            }
        }
        if (answer.size() == 0){
            answer.add(-1);
        }
        Collections.sort(answer);

        return answer;
    }


    public int bfs(String[] maps, int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y] = true;
        int days = 0;

        while (!queue.isEmpty()){
            Point temp = queue.poll();
            int nowX = temp.x;
            int nowY = temp.y;
            days += maps[nowX].charAt(nowY) -'0';

            for (int i=0;i<4;i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N  && nextY < M){
                    char value = maps[nextX].charAt(nextY);
                    if (!visited[nextX][nextY] && value != 'X'){
                        visited[nextX][nextY] = true;
                        queue.add(new Point(nextX, nextY));
                    }
                }
            }
        }
        return days;
    }
}