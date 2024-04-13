import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(gems));
        int cnt = hashSet.size();
        int min = gems.length;
        int[] answer = new int[2];
        int a = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i=0;i< gems.length;i++){
            String s = gems[i];
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);

            while (hashMap.get(gems[a]) > 1){
                hashMap.put(gems[a], hashMap.get(gems[a]) - 1);
                a++;
            }
            if (hashMap.size() == cnt && i- a < min){
                min = i-a;
                answer = new int[]{a+1, i+1};
            }

        }


        return answer;
    }
}