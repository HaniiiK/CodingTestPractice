class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x=0, y=0;
        for(int i=1; i<dots.length; i++) {
            if(dots[0][0] == dots[i][0]) {
                y = i;
            }
            if(dots[0][1] == dots[i][1]) {
                x = i;
            }
        }        
        answer = Math.abs((dots[0][1]-dots[y][1]) * (dots[0][0]-dots[x][0]));
        return answer;
    }
}