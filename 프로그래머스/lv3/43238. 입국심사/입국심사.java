import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long min = 1;
        long max = (long)times[times.length-1] * n;

        while (min <= max){
            long mid = (max + min) / 2;
            long people = 0;

            for (int i=0;i<times.length;i++){
                if (people >= n) break;
                people += mid / times[i];
            }

            if (people < n){
                min = mid + 1;
            }
            else{
                max = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}