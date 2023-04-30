class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int L_now = 12;
        int R_now = 12;
        int L_dist = 0;
        int R_dist = 0;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]==0) {
                numbers[i] = 11;
            }
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
                answer += "L";
                L_now = numbers[i]+2; //1,4,7 포지션의 값을 3,6,9로 간주 (값 비교하려고) 
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
                answer += "R";
                R_now = numbers[i];
            }else {
                L_dist = Math.abs(L_now-numbers[i])/3 + Math.abs(L_now-numbers[i])%3;
                R_dist = Math.abs(R_now-numbers[i])/3 + Math.abs(R_now-numbers[i])%3;
                // if(L_dist==3) {
                //     L_dist = 1;
                // }
                // if(R_dist==3) {
                //     R_dist = 1;
                // }
                
                if(hand.equals("left")) {
                    if(L_dist <= R_dist) {
                        answer += "L";
                        L_now = numbers[i];
                    }else {
                        answer += "R";
                        R_now = numbers[i];
                    }
                }else if(hand.equals("right")) {
                    if(L_dist < R_dist) {
                        answer += "L";
                        L_now = numbers[i];
                    }else {
                        answer += "R";
                        R_now = numbers[i];
                    }
                }
            }
            
        }
        
        
        
        System.out.println(numbers.length);
        return answer;
    }
}