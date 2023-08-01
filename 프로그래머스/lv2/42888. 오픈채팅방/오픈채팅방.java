import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> uid = new HashMap<>(); //uid, 닉네임
        List<String> enterChk = new ArrayList<>(); //"uid Enter", "uid Leave" 이런 식으로 저장
        
        for(int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            
            if(str[0].equals("Enter")) {
                if(!uid.containsKey(str[1])) {
                    uid.put(str[1], str[2]); //처음 들어온 사람이면 그냥 추가
                }else {
                    if(!uid.get(str[1]).equals(str[2])) { //들어왔던 적 있는 사람의 닉네임이 바뀐 경우
                        uid.replace(str[1], str[2]);
                    }
                }
                enterChk.add(str[1]+"님이 들어왔습니다.");
                
            }else if(str[0].equals("Leave")) {
                enterChk.add(str[1]+"님이 나갔습니다.");
                
            }else if(str[0].equals("Change")) {
                uid.replace(str[1], str[2]);
            }
        }
        
        String[] answer = new String[enterChk.size()];
        for(int i=0; i<enterChk.size(); i++) {
            String[] sep = enterChk.get(i).split("님");
            answer[i] = uid.get(sep[0])+"님"+sep[1];
        }
                
        return answer;
    }
}