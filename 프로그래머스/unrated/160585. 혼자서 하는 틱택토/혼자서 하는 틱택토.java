class Solution {
    static int cntO = 0;
    static int cntX = 0;
    static char[][] arr = new char[3][3];
    public int solution(String[] board) {

        for (int i=0;i<board.length;i++){
            arr[i] = board[i].toCharArray();
        }

        cntOX();
        if (cntO < cntX || cntO - cntX >= 2){
            return 0;
        }
        int cntWinO = cntWin('O');
        int cntWinX = cntWin('X');

        if (cntWinO != 0 && cntWinX != 0){
            return 0;
        }
        if (cntWinO > 0){
            if(cntO - cntX != 1) return 0;
        }
        if (cntWinX > 0){
            if (cntO != cntX) return 0;
        }


        return 1;

    }
    public int cntWin(char c){
        int temp = 0;
        for (int i=0;i<3;i++){
            if (c == arr[i][0] && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]){
                temp++;
            }
        }
        for (int j=0;j<3;j++){
            if (c == arr[0][j] && arr[0][j] == arr[1][j] && arr[1][j] == arr[2][j]){
                temp++;
            }
        }
        if (c == arr[0][0] && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]){
            temp++;
        }
        if (c == arr[0][2] && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]){
            temp++;
        }
        return temp;
    }

    public void cntOX() {
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (arr[i][j] == 'O'){
                    cntO++;
                }
                else if (arr[i][j] == 'X'){
                    cntX++;
                }
            }
        }
    }

}