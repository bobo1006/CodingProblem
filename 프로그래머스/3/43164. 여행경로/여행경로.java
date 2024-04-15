class Solution {
    static boolean[] visited;
    static String min;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, 0, "ICN", "ICN");
        String[] answer = min.split(" ");
        return answer;
    }

    void dfs(String[][] tickets, int num, String s, String now){
        if (num == tickets.length){
            if (min == null){
                min = s;
            }
            else if(s.compareTo(min) < 0){
                min = s;

            }
            return;
        }

        for (int i=0;i< tickets.length;i++){
        
            if (tickets[i][0].equals(now) && !visited[i]){
                visited[i] = true;
                dfs(tickets, num+1, s + " " + tickets[i][1], tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}