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
    static boolean redGoal = false, blueGoal = false;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] maze) {
        Point red = null;
        Point blue = null;
        visited = new boolean[maze.length][maze[0].length][2];

        for (int i=0;i< maze.length;i++){
            for (int j=0;j<maze[i].length;j++){
                int num = maze[i][j];
                if (num == 1) red = new Point(i,j);
                else if (num == 2) blue = new Point(i,j);
            }
        }

        visited[red.x][red.y][0] = true;
        visited[blue.x][blue.y][1] = true;
        backTracking(red, blue, maze, 0);
        if (answer == Integer.MAX_VALUE) answer = 0;

        return answer;
    }
    private boolean checkOut(Point nowRed, Point nowBlue, Point nextRed, Point nextBlue, int[][] maze){
        if (nextRed.x < 0 || nextRed.y < 0 || nextRed.x >= maze.length
                || nextRed.y >= maze[0].length) return true;

        if (nextBlue.x < 0 || nextBlue.y < 0 || nextBlue.x >= maze.length
                || nextBlue.y >= maze[0].length) return true;

        if (maze[nextRed.x][nextRed.y] == 5 || maze[nextBlue.x][nextBlue.y] == 5) return true;

        if ((nextRed.x == nowBlue.x && nextRed.y == nowBlue.y)
                && (nextBlue.x == nowRed.x && nextBlue.y == nowRed.y)) return true;

        if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) return true;

        if ((!redGoal && visited[nextRed.x][nextRed.y][0])
                || (!blueGoal && visited[nextBlue.x][nextBlue.y][1])) return true;

        return false;
    }
    private void backTracking(Point nowRed, Point nowBlue, int[][] maze, int cnt){
        if (redGoal && blueGoal){
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                Point nextRed = new Point(nowRed.x + dx[i], nowRed.y + dy[i]);
                Point nextBlue = new Point(nowBlue.x + dx[j], nowBlue.y + dy[j]);
                if (redGoal) nextRed = nowRed;
                if (blueGoal) nextBlue = nowBlue;

                if (!checkOut(nowRed, nowBlue, nextRed, nextBlue, maze)){
                    boolean temp1 = redGoal;
                    boolean temp2 = blueGoal;
                    
                    visited[nextRed.x][nextRed.y][0]= true;
                    visited[nextBlue.x][nextBlue.y][1] = true;
                    if (maze[nextRed.x][nextRed.y] == 3) redGoal = true;
                    if (maze[nextBlue.x][nextBlue.y] == 4) blueGoal = true;
                    
                    backTracking(nextRed,nextBlue,maze,cnt+1);

                    redGoal = temp1;
                    blueGoal = temp2;
                    visited[nextRed.x][nextRed.y][0] = false;
                    visited[nextBlue.x][nextBlue.y][1] = false;
                }

            }
        }
    }
}