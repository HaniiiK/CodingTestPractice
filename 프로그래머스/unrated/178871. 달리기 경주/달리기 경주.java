import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> index = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            index.put(players[i], i);
        }

        String tmp = "";
        for(int i=0; i<callings.length; i++) {
            int idx = index.get(callings[i]);            
            tmp = players[idx]; //배열 자리 바꿔주기 (현재 등수대로)
            players[idx] = players[idx-1];
            players[idx-1] = tmp;
            
            index.replace(players[idx-1], index.get(players[idx-1])-1); //hashmap value 바꿔주기 (현재 등수로)
            index.replace(players[idx], index.get(players[idx])+1);
        }
        
//         for(int i=0; i<players.length; i++) {
//             System.out.println(rank.get(players[i]));
//         }
   
        return players;
    }
}