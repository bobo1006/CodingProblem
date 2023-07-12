import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;
    public int solution(int x, int y, int n) {
        
        visited = new boolean[y+1];
        int answer = bfs(x,y,n);
        return answer;
    }
    
    public int bfs(int x, int y, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        visited[x] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int cnt = now[1];
            
            if (nowX == y){
                return cnt;
            }
            
            for (int i=1;i<=3;i++){
                int nextX = nowX;
                if (i == 1){
                    nextX += n;
                }
                else {
                    nextX *= i;
                }
                if (x <= nextX && nextX <= y){
                    if (!visited[nextX]){
                        visited[nextX] = true;
                        queue.add(new int[]{nextX, cnt+1});
                    }
                }
            }
        }
        return -1;
    }
}