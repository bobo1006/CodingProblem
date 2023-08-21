class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int floor = triangle.length;
        
        for (int i=1;i<floor;i++){
            for (int j=0;j<triangle[i].length;j++){
                if (j==0){
                    triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                }
                else if (j==triangle[i].length-1){
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                }
                else {
                    triangle[i][j] = Math.max(triangle[i-1][j], triangle[i-1][j-1]) + triangle[i][j];
                }
            }
        }

        for (int i=0;i<triangle[floor - 1].length;i++){
            int now = triangle[floor - 1][i];
            if (answer < now){
                answer = now;
            }
        }
        return answer;
    }
}