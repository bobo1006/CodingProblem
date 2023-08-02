import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> map_want = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map_discount = new HashMap<>();
        for (int i=0;i<want.length;i++){
            map_want.put(want[i], number[i]);
        }

        for (int i=0;i<10;i++) {
            putMap(discount,map_discount,i);
        }
        
        if(isSameMap(map_discount)){
            answer++;
        }
        
        for (int i=10;i<discount.length;i++){
            map_discount.put(discount[i-10],map_discount.get(discount[i-10]) - 1);
            putMap(discount, map_discount, i);

            if(isSameMap(map_discount)){
                answer++;
            }
        }
        return answer;
    }

    private boolean isSameMap(HashMap<String, Integer> map_discount){
        for (String key:map_want.keySet()){
            if (!map_discount.containsKey(key)){
                return false;
            }
            if (map_want.get(key) != map_discount.get(key)){
                return false;
            }
        }
        return true;
    }
    private void putMap(String[] discount, HashMap<String, Integer> map_discount, int i){
        if (map_discount.containsKey(discount[i])) {
            map_discount.put(discount[i], map_discount.get(discount[i]) + 1);
        } else {
            map_discount.put(discount[i], 1);
        }
    }
}