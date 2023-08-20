import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Arrays.sort(A);

        for (int i=0;i<B.length;i++){
            priorityQueue.add(B[i]);
        }
        for (int i=0;i<A.length;i++){
            int nowA = A[i];

            while (!priorityQueue.isEmpty()){
                int nowB = priorityQueue.poll();
                if (nowB > nowA){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}