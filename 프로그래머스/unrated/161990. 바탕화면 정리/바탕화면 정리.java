class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4]; //제일위 제일왼 제일아래 제일오
        
        answer[0] = 100;
        answer[1] = 100;
        answer[2] = -1;
        answer[3] = -1;
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j)=='#') {
                    if(answer[0] >= i) {
                        answer[0] = i;
                    }
                    if(answer[1] >= j) {
                        answer[1] = j;
                    }
                    if(answer[2] <= i+1) {
                        answer[2] = i+1;
                    }
                    if(answer[3] <= j+1) {
                        answer[3] = j+1;
                    }
                }
            }
        }
        return answer;
    }
}