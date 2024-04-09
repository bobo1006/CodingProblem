import java.util.ArrayList;

class Solution {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int answer = 0;
    public int solution(int n, int[][] lighthouse) {
        visited = new boolean[n];

        for (int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for (int i=0;i<lighthouse.length;i++){
            int n1 = lighthouse[i][0];
            int n2 = lighthouse[i][1];
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        dfs(0,1);
        return answer;
    }

    private int dfs(int pre, int node){
        if (list.get(node).size() == 1 && list.get(node).get(0) == pre) return 1;
        
        int child = 0;
        
        for (int i:list.get(node)){
            if (i == pre) continue;
            child += dfs(node, i);
        }
        if (child == 0) return 1;
        answer++;
        return 0;
    }
}