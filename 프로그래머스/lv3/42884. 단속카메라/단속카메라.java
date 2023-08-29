import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        
        int camera = routes[0][1];

        for (int i=0;i<routes.length;i++){
            if (camera < routes[i][0]){
                answer++;
                camera = routes[i][1];
            }
            
        }
        return answer;
    }
}