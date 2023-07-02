import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        sort(targets);
        int answer = findX(targets);
        return answer;
    }

    public void sort(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] - o2[1];
        });

    }

    public int findX(int[][] arr){
        int temp = arr[0][1];
        int cnt = 1;
        
        for (int i=0;i< arr.length;i++){
            
            if (temp <= arr[i][0]){
                    temp = arr[i][1];
                    cnt++;
            }
            
        }
        return cnt;
    }
}