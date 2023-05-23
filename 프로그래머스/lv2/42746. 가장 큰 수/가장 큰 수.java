import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            str[i] = numbers[i]+"";
        }
        Arrays.sort(str, (a,b)->(a+b).compareTo(b+a));
   
        if(str[str.length-1].equals("0")) {
            return "0";
        }
        
        for(int i=str.length-1; i>=0; i--) {
            answer += str[i];
        }
        
        // for(int i=0; i<answer.length(); i++) {
        //     if(answer.charAt(i)=='0') {
        //         answer = answer.substring(i+1);
        //     }else if(answer.charAt(i)!='0') {
        //         break;
        //     }
        // }
        // if(answer.isEmpty()) {
        //     answer = "0";
        // }
        
        return answer;
    }
}