import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int len = numbers.length;
        
        Arrays.sort(numbers);
        answer = numbers[len-1] * numbers[len-2];
        
/*        int m1=0, m2=0, idx=0;
        for(int i=0; i<numbers.length; i++) {
            if(m1<numbers[i]) {
                m1 = numbers[i];
                idx = i;
            }
        }
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]==m1 && i==idx) {
            	continue;
            }
            if(m2<numbers[i]) {
                m2 = numbers[i];
            }
        }
        answer = m1*m2;*/
        return answer;
    }
}