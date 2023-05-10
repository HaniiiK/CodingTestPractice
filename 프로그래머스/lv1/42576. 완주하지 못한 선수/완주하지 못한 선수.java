import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        answer = participant[participant.length-1];
        for(int i=0; i<completion.length; i++) {
            if(participant[i].equals(completion[i])) {
                continue;
            }else {
                answer = participant[i];
                break;
            }
        }
        
        
        
//         for(int i=0; i<participant.length; i++) {
//             for(int j=0; j<completion.length; j++) {
//                 if(participant[i].equals(completion[j])) {
//                     participant[i] = null;
//                     completion[j] = null;
//                     break;
//                 }
//             }
//         }
        
//         for(int i=0; i<participant.length; i++) {
//             if(participant[i]!=null) {
//                 answer = participant[i];
//             }
//         }
        return answer;
    }
}