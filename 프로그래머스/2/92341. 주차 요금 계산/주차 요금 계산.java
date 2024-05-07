import javax.print.DocFlavor;
import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {

        HashMap<Integer, Integer> inMap = new HashMap<>();
        HashMap<Integer, Integer> totalMap = new HashMap<>();

        for (int i=0;i< records.length;i++){
            String[] record = records[i].split(" ");
            String[] time = record[0].split(":");
            int carNum = Integer.parseInt(record[1]);
            String s = record[2];
            int t = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if (s.equals("IN")){
                inMap.put(carNum, t);
                continue;
            }

            totalMap.put(carNum, totalMap.getOrDefault(carNum, 0) + t - inMap.get(carNum));
            inMap.remove(carNum);
        }

        int max = 1439;
        ArrayList<Integer> keys = new ArrayList<>(inMap.keySet());
        for (int key:keys){
            totalMap.put(key, totalMap.getOrDefault(key, 0) + max - inMap.get(key));
        }

        keys = new ArrayList<>(totalMap.keySet());
        Collections.sort(keys);

        int[] answer = new int[keys.size()];
        int idx = 0;
        for (int key:keys){
            answer[idx++] = pay(totalMap.get(key), fees);
        }
        return answer;
    }
    private int pay(int t, int[] fees){
        int cost = fees[1];
        if (t <= fees[0]){
            return cost;
        }
        t -= fees[0];

        if(t % fees[2] != 0){
            cost += (t / fees[2] + 1) * fees[3];
        }
        else cost += t / fees[2] * fees[3];

        return cost;
    }
}