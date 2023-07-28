import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int end = people.length-1;
        int start = 0;
        Arrays.sort(people);

        for (int i=end;i>=start;i--){
            int one = people[i];
            int two = people[start];

            if (one + two <= limit){
                answer++;
                start++;
            }
            else{
                answer++;
            }

        }
        return answer;
    }
}