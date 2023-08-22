class Solution {
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(words, target, begin, 0, visited);
        return answer;
    }

    private void dfs(String[] words, String target, String now, int cnt, boolean[] visited){
        if (target.equals(now)){
            answer = cnt;
            return;
        }


        for (int i=0;i<words.length;i++){
            if (check(now, words[i]) && !visited[i]){
                visited[i] = true;
                dfs(words, target, words[i], cnt + 1, visited);
                visited[i] = false;
            }
        }
    }
    private boolean check(String s1, String s2){
        int cnt = 0;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
        }
        if (cnt > 1){
            return false;
        }
        return true;
    }
}