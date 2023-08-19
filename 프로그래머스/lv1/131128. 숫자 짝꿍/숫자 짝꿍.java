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
        StringBuffer sb1 = new StringBuffer();
        for(int i=0; i<10; i++) {
            num = Math.min(cntX[i], cntY[i]);
            if(num>0) {
                for(int j=0; j<num; j++) {
                    sb1.append(i+"");
//                    answer += i+"";
                }
            }
        }
        
        
        // for(int i=0; i<X.length(); i++) {
        //     for(int j=0; j<Y.length(); j++) {
        //         if(X.charAt(i)==Y.charAt(j)) {
        //             answer += X.charAt(i);
        //             Y = Y.substring(0,j).concat(Y.substring(j+1));
        //             break;
        //         }
        //     }
        // }
        String answer = sb1.toString();

        StringBuffer sb = new StringBuffer();
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