import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        
        String answer = "";
        for(int i=c.length-1; i>=0; i--) {
            answer += c[i];
        }

        //String answer = String.valueOf(c);
        return answer;
    }
}