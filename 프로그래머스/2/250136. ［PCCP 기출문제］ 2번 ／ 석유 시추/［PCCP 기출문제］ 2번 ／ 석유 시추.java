import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int[] map;

    public int solution(int[][] land) {
        int answer = 0;

        return findMax(land);
    }

    private int findMax(int[][] land){
        int row = land.length;
        int col = land[0].length;
        visited = new boolean[row][col];
        map = new int[col];


        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (visited[i][j]) continue;
                if (land[i][j] == 1) getSize(i, j, row, col, land);
            }
        }

        /* test code
        
        for (int i=0;i<col;i++){
            System.out.println(map[i]);
        }
        */
        int max = Arrays.stream(map).max().getAsInt();

        return max;
    }

    private void getSize(int x, int y, int row, int col, int[][] land){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean[] location = new boolean[col];
        visited[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            location[now[1]] = true;
            
            for (int i=0;i<4;i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
                if (land[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                size++;
                queue.add(new int[]{nextX, nextY});
            }
        }

        for (int i=0;i<col;i++){
            if (location[i]) map[i] += size;
        }
    }
}