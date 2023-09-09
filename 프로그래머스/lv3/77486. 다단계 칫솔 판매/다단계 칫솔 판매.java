import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, String[]> hashMap = new HashMap<>();

        for(int i=0;i< enroll.length;i++){
            String myName = enroll[i];
            String parentName = referral[i];
            String myIndex = String.valueOf(i);

            hashMap.put(myName, new String[]{parentName,myIndex});
        }

        for (int i=0;i<seller.length;i++){
            int cost = amount[i] * 100;
            String name = seller[i];

            while (cost > 0){
                String[] now = hashMap.get(name);
                int index = Integer.parseInt(now[1]);
                answer[index] += cost - (cost/10);
                cost /= 10;
                name = now[0];

                if (now[0].equals("-")){
                    break;
                }
            }
        }
        return answer;
    }

}