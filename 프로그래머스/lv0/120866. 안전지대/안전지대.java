class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        int[][] cnt = new int[len+2][len+2];        
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(board[i][j] == 1) {
                    cnt[i][j] = 1;
                    cnt[i][j+1] = 1;
                    cnt[i][j+2] = 1;
                    cnt[i+1][j] = 1;
                    cnt[i+1][j+1] = 1;
                    cnt[i+1][j+2] = 1;
                    cnt[i+2][j] = 1;
                    cnt[i+2][j+1] = 1;
                    cnt[i+2][j+2] = 1;
                }
            }
        }
        
        for(int i=1; i<=len; i++) {
            for(int j=1; j<=len; j++) {
                if(cnt[i][j] == 0) {
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}