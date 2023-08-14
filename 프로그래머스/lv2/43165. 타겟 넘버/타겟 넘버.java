class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
       
        find(numbers, target, 0, 0);
        int answer = cnt;
        return answer;
    }
    private void find(int[] numbers, int target, int num, int i){
        if (i >= numbers.length){
            if (num == target){
                cnt++;
            }
            return;
        }
        find(numbers, target, num + numbers[i], i+1);
        find(numbers, target, num - numbers[i], i+1);
        
    }
}