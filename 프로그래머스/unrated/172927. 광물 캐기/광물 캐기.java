import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] value = new int[minerals.length/5 +1][3];
        measure(minerals, value, picks);
        sort(value);
        int answer = mining(picks, value);
        return answer;
    }
    public void measure(String[] minerals, int[][] value, int[] picks){
        int end = picks[0] + picks[1] + picks[2];

        for (int i=0;i<minerals.length;i++){
            if (end * 5 <= i) break;
            if (minerals[i].equals("diamond")){
                value[i/5][0]++;
            }
            else if (minerals[i].equals("iron")) {
                value[i/5][1]++;
            }
            else {
                value[i/5][2]++;
            }
        }
    }

    public void sort(int[][] value){
        Arrays.sort(value, new Comparator<int[]> () {
            @Override
            public int compare(int[] o1, int[] o2){
                if (o1[0] == o2[0]){
                    if (o1[1] == o2[1]){
                        return o2[2] - o1[2];
                    }
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
    }

    public int mining(int[] picks, int[][] value){
        int temp = 0;

        for (int i=0;i<value.length;i++){
            if (picks[0] > 0){
                picks[0]--;
                temp += value[i][0] + value[i][1] + value[i][2];
            }
            else if(picks[1] > 0){
                picks[1]--;
                temp += value[i][0] * 5 + value[i][1] + value[i][2];
            }
            else if (picks[2] > 0){
                picks[2]--;
                temp += value[i][0] * 25 + value[i][1] * 5 + value[i][2];
            }
            else break;
        }
        return temp;
    }

}