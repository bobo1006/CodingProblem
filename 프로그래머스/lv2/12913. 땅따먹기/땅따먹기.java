class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i=1;i< land.length;i++){
            for (int j=0;j<4;j++){
                int n = land[i][j];
                
                switch (j){
                    case 0:
                        land[i][j] = Math.max(land[i-1][j+1] + n, Math.max(land[i-1][j+2] + n, land[i-1][j+3] + n));
                        break;
                    case 1:
                        land[i][j] = Math.max(land[i-1][j-1] + n, Math.max(land[i-1][j+1] + n, land[i-1][j+2] + n));
                        break;
                    case 2:
                        land[i][j] = Math.max(land[i-1][j-2] + n, Math.max(land[i-1][j-1] + n, land[i-1][j+1] + n));
                        break;
                    case 3:
                        land[i][j] = Math.max(land[i-1][j-3] + n, Math.max(land[i-1][j-2] + n, land[i-1][j-1] + n));
                        break;
                }
            }
        }
        for (int i=0;i<4;i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}