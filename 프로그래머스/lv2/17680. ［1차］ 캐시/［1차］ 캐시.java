import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();

        for (String city:cities){
            boolean sameInList = false;

            for (String cache:list) {
                if (cache.equalsIgnoreCase(city)) {
                    list.remove(cache);
                    list.add(city);
                    answer++;
                    sameInList = true;
                    break;
                }
            }
            if (!sameInList){
                if (cacheSize != 0 && list.size() >= cacheSize){
                    list.remove(0);
                    list.add(city);
                }
                else if (list.size() < cacheSize){
                    list.add(city);
                }
                answer+=5;
            }
        }
        return answer;
    }
}