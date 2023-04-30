import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -3; //아예 연관 없는 아무 숫자
                    reserve[j] = -1;
                    answer++;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]-1==reserve[j]) {
                    System.out.println(reserve[j]);
                    answer++;
                    reserve[j] = -1;
                    break;
                }else if(lost[i]+1==reserve[j]) {
                    System.out.println(reserve[j]);
                    answer++;
                    reserve[j] = -1;                    
                    break;
                }
            }
            
        }
        
        
        return answer;
    }
}