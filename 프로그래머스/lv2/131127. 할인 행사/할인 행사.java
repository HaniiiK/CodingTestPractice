import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }

        int cnt=0; //몇 일 연속인지 카운트
        int value=0; //key의 value 임시저장
        for(int i=0; i<discount.length-9; i++) {
            for(int j=0; j<10; j++) {
                if(map.containsKey(discount[i+j])) {
                    value = map.get(discount[i+j]);
                    if(value!=0) {
                        cnt++;
                        map.replace(discount[i+j], --value);
                    }else {
                        cnt = 0;
                        for(int k=0; k<want.length; k++) {
                            map.put(want[k], number[k]);
                        }
                        break;
                    }
                }else {
                    cnt = 0;
                    for(int k=0; k<want.length; k++) {
                        map.put(want[k], number[k]);
                    }
                    break;
                }                
            }
            
            if(cnt==10) {
                answer++;
            }
            cnt = 0;
            for(int k=0; k<want.length; k++) {
                map.put(want[k], number[k]);
            }
        }
        
        return answer;
    }
}