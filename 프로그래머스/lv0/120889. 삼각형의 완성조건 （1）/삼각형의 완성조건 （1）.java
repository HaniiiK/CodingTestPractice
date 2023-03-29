import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        if(sides[0]+sides[1]>sides[2]) {
            answer = 1;
        } else {
            answer = 2;
        }
        
/*        int max=sides[0];
        int sum=0;
        for(int i=0; i<sides.length; i++) {
            sum += sides[i];
            if(max<sides[i]) {
                max = sides[i];
            }
        }
        sum -= max;
        if(sum>max) {
            answer = 1;
        }else {
            answer = 2;
        }*/
        return answer;
    }
}