import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] s:clothes){
            String key = s[1];
            if (map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }
            else{
                map.put(key, 1);
            }
        }
        
        for (int i:map.values()){
            answer *= i+1;
        }

        return answer - 1;
    }
}