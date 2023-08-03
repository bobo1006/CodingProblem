class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        boolean find = false;

        while (!find){
            for (int i=0;i<=n-2;i+=2){
                if (i < a && i < b && a <= i+2 && b <= i+2){
                    find = true;
                    break;
                }
            }
            a = (a % 2 == 1) ? a/2 + 1 : a/2;
            b = (b % 2 == 1) ? b/2 + 1 : b/2;
            n /= 2;
            answer++;
        }

        return answer;
    }
}