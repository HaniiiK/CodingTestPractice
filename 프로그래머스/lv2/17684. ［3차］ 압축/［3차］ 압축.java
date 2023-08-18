import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        for(int i='A', j=1; i<='Z'; i++, j++) {
            dictionary.put((char)i+"", j);
        }
        int dicIdx = 27;
        
        List<Integer> answerList = new ArrayList<>();
        String s = "";
        int j;
        for(int i=0; i<msg.length(); i++) {
            j=1;
            while(true) {
                if(i+j>msg.length()) {
                    break;
                }

                s = msg.substring(i, i+j);
                if(!dictionary.containsKey(s)) {
                    dictionary.put(s, dicIdx++);
                    break;
                }
                j++;
            }
            if(i+j>msg.length()) {
                s = s.concat(msg.charAt(msg.length()-1)+""); //마지막 글자가 안 붙어서 붙여줌
            }
            answerList.add(dictionary.get(s.substring(0, s.length()-1)));

            i += j-2; //'현재 입력'이 두 글자 이상일 경우 '다음 글자' idx 바꿔주려고
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}