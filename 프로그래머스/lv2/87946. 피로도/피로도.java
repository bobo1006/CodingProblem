import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        int answer = max;
        return answer;
    }

    private void dfs(int[][] dungeons, boolean[] visited, int k, int cnt){
        if (max < cnt){
            max = cnt;
        }

        for (int i=0;i<dungeons.length;i++){
            if (!visited[i]){
                if (k >= dungeons[i][0]){
                    visited[i] = true;
                    dfs(dungeons, visited, k - dungeons[i][1], cnt+1);
                    visited[i] = false;
                }

            }

        }
    }
}