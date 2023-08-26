import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i=0;i<scoville.length;i++){
            priorityQueue.add(scoville[i]);
        }

        while (!priorityQueue.isEmpty()){
            int first = priorityQueue.poll();

            if (K > first){
                if (priorityQueue.isEmpty()){
                    answer = -1;
                    break;
                }
                int second = priorityQueue.poll();
                priorityQueue.add(first + (second * 2));
                answer++;
            }
        }
        return answer;
    }
}