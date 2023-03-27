class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int lar=sides[0], sml=sides[1];
        if(sides[0] < sides[1]) {
            lar = sides[1];
            sml = sides[0];
        }        
        int i = lar-sml+1;
        while(sml+i>lar && i<lar+sml) {
            answer++;
            i++;
        }
        return answer;
    }
}