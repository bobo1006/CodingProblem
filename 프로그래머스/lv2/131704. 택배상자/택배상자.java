import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i=1;i<=order.length;i++){
            if (i == order[index]){
                index++;
                answer++;
            }
            else if (!stack.isEmpty() && stack.peek() == order[index]){
                index++;
                answer++;
                stack.pop();
                i--;
            }
            else{
                stack.add(i);
            }
        }

        while (!stack.isEmpty()){
            if (stack.peek() == order[index]){
                index++;
                answer++;
                stack.pop();
            }
            else break;
        }

        return answer;
    }
}