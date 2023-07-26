import java.util.Stack;

class Solution
{
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++){
            char next = s.charAt(i);

            if (stack.isEmpty()){
                stack.push(next);
                continue;
            }

            char now = stack.peek();

            if (now == next){
                stack.pop();
            }
            else {
                stack.push(next);
            }
        }
        int answer = 0;
        if (stack.isEmpty()){
            answer = 1;
        }
        return answer;
    }
}