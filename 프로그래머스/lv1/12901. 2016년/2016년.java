class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] months = {31,29,31,30,31,30,31,31,30,31,30,31};
        int day = b;

        for (int i=0;i<a-1;i++){
            day += months[i];
        }

        day %= 7;

        switch (day){
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
            case 0:
                answer = "THU";
                break;

        }
        return answer;
    }
}