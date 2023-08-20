import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[] cntX = new int[10]; //각 인덱스에 해당하는 숫자가 몇 개인지
        int[] cntY = new int[10];
        for(int i=0; i<X.length(); i++) {
            cntX[X.charAt(i)-'0']++;
        }
        for(int i=0; i<Y.length(); i++) {
            cntY[Y.charAt(i)-'0']++;
        }
        
        int num;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<10; i++) {
            num = Math.min(cntX[i], cntY[i]);
            if(num>0) {
                for(int j=0; j<num; j++) {
                    sb.append(i+"");
                }
            }
        }
        
        String answer = sb.toString();
        sb.delete(0, sb.capacity()-1); //다시 쓰려고 초기화

        if(answer.isEmpty()) {
            answer = "-1";
        }else {
            String[] arr = answer.split("");
            Arrays.sort(arr);

            for(int i=arr.length-1; i>=0; i--) {
                sb.append(arr[i]);
            }            
            answer = sb.toString();
            
            if(answer.charAt(0)=='0') {
                answer = "0";
            }
        }
        
        return answer;
    }
}