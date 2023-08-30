import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Node{
        int node;
        int len;
        Node(int node, int len){
            this.node = node;
            this.len = len;
        }
    }
    public int solution(int n, int[][] edge) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for (int i=0;i<edge.length;i++){
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }
        int answer = bfs(list, n);
        return answer;
    }

    public int bfs(ArrayList<ArrayList<Integer>> list, int n){
        boolean[] visited = new boolean[n+1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;
        int max = 0;
        int cnt = 0;
        
        while (!queue.isEmpty()){
            Node now = queue.poll();
            if (max < now.len){
                max = now.len;
                cnt = 1;
            }
            else if (max == now.len){
                cnt++;
            }
            for (int i:list.get(now.node)){
                if (!visited[i]){
                    queue.add(new Node(i, now.len + 1));
                    visited[i] = true;
                }
            }
        }
        return cnt;
    }
}