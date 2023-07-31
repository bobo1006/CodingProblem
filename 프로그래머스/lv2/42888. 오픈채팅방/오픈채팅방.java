import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    static HashMap<String, String> map = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[] record) {
        for (String s:record){
            String[] temp = s.split(" ");
            String command = temp[0];
            String userId = temp[1];
            String nick = "";
            if (!command.equals("Leave")){
                nick = temp[2];
            }

            if (command.equals("Enter")){
                enter(userId, nick);
            }
            else if (command.equals("Change")){
                change(userId,nick);
            }
            else{
                leave(userId);
            }
        }

        String[] answer = new String[list.size()];
        makeAnswer(answer);
        return answer;
    }

    private void enter(String userId, String nick){
        map.put(userId, nick);
        list.add(userId + ",님이 들어왔습니다.");
    }
    private void change(String userId, String nick){
        map.put(userId, nick);
    }
    private void leave(String userId){
        list.add(userId + ",님이 나갔습니다.");
    }
    private void makeAnswer(String[] answer){
        int index = 0;
        
        for (String s:list){
            String[] temp = s.split(",");
            String key = temp[0];
            String line = temp[1];
            answer[index++] = map.get(key) + line;
        }
    }
}