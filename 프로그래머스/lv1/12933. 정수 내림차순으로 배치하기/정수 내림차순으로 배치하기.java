import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String str = n+"";
        char[] ch = str.toCharArray();
        
        Arrays.sort(ch);
        str = "";
        for(int i=0; i<ch.length; i++) {
            str += ch[ch.length-1-i];
        }
        System.out.println(str);
        long answer = Long.parseLong(str);
        return answer;
    }
}