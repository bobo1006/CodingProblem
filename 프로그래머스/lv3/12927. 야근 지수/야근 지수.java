import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0;i<works.length;i++){
            priorityQueue.add(works[i]);
        }

        while (n != 0){
            int now = priorityQueue.poll();
            now--;
            n--;
            if (now < 0){
                now = 0;
            }
            priorityQueue.add(now);
        }
        
        while (!priorityQueue.isEmpty()){
            answer += Math.pow(priorityQueue.poll(),2);
        }
        return answer;
    }
}