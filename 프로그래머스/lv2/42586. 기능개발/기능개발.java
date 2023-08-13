import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            int progress = progresses[i];
            int speed = speeds[i];
            int temp = 100 - progress;

            int day = temp % speed != 0 ? temp/speed + 1 : temp/speed;
            days[i] = day;
        }
        ArrayList<Integer> list = new ArrayList<>();

        int preDay = days[0];
        int cnt = 1;
        for (int i=1;i<days.length;i++){
            if (preDay >= days[i]){
               cnt++;
            }
            else{
                preDay = days[i];
                list.add(cnt);
                cnt = 1;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for (int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}