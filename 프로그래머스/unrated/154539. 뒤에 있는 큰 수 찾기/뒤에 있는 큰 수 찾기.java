import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1;i< numbers.length;i++){

            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){
                int temp = stack.pop();
                answer[temp] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int temp = stack.pop();
            answer[temp] = -1;
        }
        return answer;
    }
}