import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<tangerine.length;i++){
            int key = tangerine[i];

            if (map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }
            else{
                map.put(key, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1,o2) -> map.get(o2) - map.get(o1));

        for (int i:list){
            if (k <= 0) break;
            int value = map.get(i);
            k -= value;
            answer++;
        }
        return answer;
    }
}