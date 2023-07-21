class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        int x=0; int y=0;
        for(int i=0; i<answer.length; i++) {
            x = (int)(left/n + 1);
            y = (int)(left%n + 1);
            left++;
            answer[i] = Math.max(x,y);
            // if(x>=y) {
            //     answer[i] = x;
            // }else {
            //     answer[i] = y;
            // }
        }

        return answer;
    }
}