import java.util.Arrays;

class Solution {
    static int cnt = 0;
    public int solution(int[] number) {

        findThree(0,0,0,number);
        return cnt;
    }
    public void findThree(int depth, int start, int sum, int[] number){
        if (depth == 3){
            if (sum == 0) cnt++;
            return;
        }

        for (int i=start;i<number.length;i++){
            findThree(depth + 1, i + 1, sum + number[i], number);
        }

    }
}