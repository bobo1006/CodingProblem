class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n / a > 0){
            int newBottle = n/a * b;
            n = n%a + newBottle;
            answer += newBottle;
        }

        return answer;
    }

}