class Solution {
    public int solution(int[] stones, int k) {
        int answer = getPeople(stones, k);

        return answer;
    }
    private int getPeople(int[] stones, int k){
        int start = 1;
        int end = 200000000;

        while (start <= end){
            int mid = (start + end) / 2;

            if(crossBridge(stones, k, mid)){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }

        return start;
    }

    private boolean crossBridge(int[] stones, int k, int mid){
        int cnt = 0;
        for (int stone : stones){
            if (stone <= mid){
                cnt++;
            }
            else {
                cnt = 0;
                continue;
            }
            if (cnt >= k){
                return false;
            }
        }
        return true;
    }
}