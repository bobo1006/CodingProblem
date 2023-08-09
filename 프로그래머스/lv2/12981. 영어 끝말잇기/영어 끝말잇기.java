import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }
        String now = words[0];
        list.get(now.charAt(0) - 'a').add(now);
        char beforeWordLast = now.charAt(now.length() - 1);

        for (int i=1;i<words.length;i++){
            now = words[i];
            char first = now.charAt(0);

            if (beforeWordLast != first){
                answer = new int[] {i%n + 1, i/n + 1};
                break;
            }
            if (list.get(first - 'a').contains(now)){
                answer = new int[] {i%n + 1, i/n + 1};
                break;
            }
            list.get(first-'a').add(now);
            beforeWordLast = now.charAt(now.length() - 1);
        }
        return answer;
    }
}