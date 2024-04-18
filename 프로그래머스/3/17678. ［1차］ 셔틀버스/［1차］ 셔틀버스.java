import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[][] time = new int[timetable.length][2];

        for (int i=0;i< timetable.length;i++){
            String[] temp = timetable[i].split(":");
            time[i][0] = Integer.parseInt(temp[0]);
            time[i][1] = Integer.parseInt(temp[1]);

        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int startH = 8;
        int startM = 60-t;
        int index = 0;
        int cnt = 0;

        for (int i=0;i<n;i++){
            startM += t;
            if (startM >= 60){
                startM -= 60;
                startH++;
            }

            cnt = 0;
            while (index < time.length){
                if (time[index][0] > startH) break;
                if (time[index][0] == startH && time[index][1] > startM) break;
                cnt++;
                index++;

                if (cnt == m){
                    break;
                }
            }

        }

        if (cnt == m) {
            int hour = time[index-1][0];
            int min = time[index-1][1] - 1;
            if (min < 0){
                hour--;
                min += 60;
            }
            answer = toTime(hour, min);
        }

        else{
            answer = toTime(startH, startM);
        }
        return answer;
    }

    private String toTime(int hour, int min){
        String answer = "";
        if (hour < 10){
            answer = "0";
        }
        answer += hour + ":";
        if (min < 10){
            answer += "0";
        }
        answer += min;
        
        return answer;
    }
}