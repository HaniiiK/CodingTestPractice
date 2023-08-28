class Solution {
    int solution(int[][] land) {
        int answer = 0;
       
        int[][] maxSum = new int[land.length][4];
        for(int i=0; i<4; i++) {
            maxSum[0][i] = land[0][i];
        }
        
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<4; j++) {
                for(int k=0; k<4; k++) {
                    if(j!=k) {
                        maxSum[i][j] = Math.max(maxSum[i][j], maxSum[i-1][k]+land[i][j]);                        
                    }
                }                
            }
        }
        
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, maxSum[land.length-1][i]);
        }
        
        return answer;
    }
}