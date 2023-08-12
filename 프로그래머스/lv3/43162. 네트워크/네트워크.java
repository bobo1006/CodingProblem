import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] network;
    public int solution(int n, int[][] computers) {

        network = new int[n];
        for (int i=0;i<n;i++){
            network[i] = i;
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (computers[i][j] == 1){
                    union(i,j);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0;i<n;i++){
            int temp = find(i);
            if (!list.contains(temp)){
                list.add(temp);
            }
        }

        int answer = list.size();
        return answer;
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            if (a < b){
                network[b] = a;
            }
            else {
                network[a] = b;
            }
        }

    }
    private int find(int a){
        if (network[a] == a){
            return a;
        }
        return network[a] = find(network[a]);
    }
}