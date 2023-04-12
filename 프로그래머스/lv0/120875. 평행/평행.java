class Solution {
    
    public double findA(int[] dot1, int[] dot2) {
        
        return (double) (dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
        
    }
    
    public int solution(int[][] dots) {
        int answer = 0;
        
        if(findA(dots[0], dots[1]) == findA(dots[2], dots[3])) {
            return 1;
        } else if(findA(dots[0], dots[2]) == findA(dots[1], dots[3])) {
            return 1;
        } else if(findA(dots[0], dots[3]) == findA(dots[1], dots[2])) {
            return 1;
        }
        
/*        
        if((double)((dots[0][1]-dots[1][1]) / (dots[0][0]-dots[1][0])) == (double)((dots[2][1]-dots[3][1]) / (dots[2][0]-dots[3][0]))) {
            answer = 1;
        }else if((double)((dots[0][1]-dots[2][1]) / (dots[0][0]-dots[2][0])) == (double)((dots[1][1]-dots[3][1]) / (dots[1][0]-dots[3][0]))) {
            answer = 1;
        }else if((double)((dots[0][1]-dots[3][1]) / (dots[0][0]-dots[3][0])) == (double)((dots[1][1]-dots[2][1]) / (dots[1][0]-dots[2][0]))) {
            answer = 1;
        } */
        return answer;
    }
}