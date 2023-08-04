import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Process{
        int loc;
        int priority;
        Process(int loc,int priority){
            this.loc = loc;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();

        for (int i=0;i<priorities.length;i++){
            queue.add(new Process(i,priorities[i]));
        }

        while (!queue.isEmpty()){
            Process now = queue.poll();
            boolean sw = false;
            for (Process p:queue){
                if(p.priority > now.priority){
                    queue.add(now);
                    sw = true;
                    break;
                }
            }

            if (!sw){
                answer++;
                if (location == now.loc){
                    break;
                }
            }

        }
        return answer;
    }
}