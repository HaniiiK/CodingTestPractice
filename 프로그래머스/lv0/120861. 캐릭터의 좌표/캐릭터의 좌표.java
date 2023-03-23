class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int len = keyinput.length;
        int[] answer = {0,0};
        
        for(int i=0; i<len; i++) {
            if(keyinput[i].equals("left")) {
                if(-answer[0] < board[0]/2) {
                    answer[0]--;                    
                }
            } else if(keyinput[i].equals("right")) {
                if(answer[0] < board[0]/2) {
                    answer[0]++;                    
                }
            } else if(keyinput[i].equals("down")) {
                if(-answer[1] < board[1]/2) {
                    answer[1]--;                    
                }
            } else if(keyinput[i].equals("up")) {
                if(answer[1] < board[1]/2) {
                    answer[1]++;                    
                }
            }
        }
        return answer;
    }
}