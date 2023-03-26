import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        int index=0;
        for(int i=0; i<my_string.length(); i++) {
            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
                index++;
            }
        }

        int[] answer = new int[index];
        index=0;
        for(int i=0; i<my_string.length(); i++) {
            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
                answer[index] = my_string.charAt(i)-'0';
                index++;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}