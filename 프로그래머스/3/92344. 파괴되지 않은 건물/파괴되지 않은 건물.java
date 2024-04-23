class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] degree = new int[board.length+1][board[0].length+1];

        for (int i=0;i< skill.length;i++){

            if (skill[i][0] == 1){
                degree[skill[i][1]][skill[i][2]] -= skill[i][5];
                degree[skill[i][1]][skill[i][4] + 1] += skill[i][5];
                degree[skill[i][3] + 1][skill[i][2]] += skill[i][5];
                degree[skill[i][3] + 1][skill[i][4] + 1] -= skill[i][5];
            }
            else{
                degree[skill[i][1]][skill[i][2]] += skill[i][5];
                degree[skill[i][1]][skill[i][4] + 1] -= skill[i][5];
                degree[skill[i][3] + 1][skill[i][2]] -= skill[i][5];
                degree[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];
            }
        }
        for (int i=0;i<degree[0].length;i++){
            for (int j=0;j<degree.length-1;j++){
                degree[j+1][i] += degree[j][i];
            }
        }

        for (int i=0;i<degree.length;i++){
            for (int j=0;j<degree[0].length-1;j++){
                degree[i][j+1] += degree[i][j];
            }
        }
        int answer = 0;

        for (int i=0;i<board.length;i++){
            for (int j=0;j< board[i].length;j++){
                if (board[i][j] + degree[i][j] > 0){
                    answer++;
                }
            }
        }

        return answer;
    }
}