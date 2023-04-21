import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<db.length; i++) {
            map.put(db[i][0], db[i][1]);
        }
        
        if(map.containsKey(id_pw[0])) {
            if(map.get(id_pw[0]).equals(id_pw[1])) {
                answer = "login";
            }else {
                answer = "wrong pw";
            }
        }
        
        // for(int i=0; i<db.length; i++) {
        //     if(db[i][0].equals(id_pw[0])) {
        //         if(db[i][1].equals(id_pw[1])) {
        //             answer = "login";
        //             break;
        //         }
        //         answer = "wrong pw";
        //     }
        // }
        
        return answer;
    }
}