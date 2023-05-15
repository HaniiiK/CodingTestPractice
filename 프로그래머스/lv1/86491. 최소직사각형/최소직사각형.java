class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_total = 0; //전체 중 최대
        int max_pair = 0; //최대의 짝꿍
        
        for(int i=0; i<sizes.length; i++) {
            for(int j=0; j<sizes[i].length; j++) {
                if(sizes[i][j]>max_total) {
                    max_total = sizes[i][j];
                    if(j==0) {
                        max_pair = sizes[i][1];
                    }else {
                        max_pair = sizes[i][0];
                    }
                }
            }
        }
        
        int smaller=0; //페어 중 더 작은 수
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0]<sizes[i][1]) {
                smaller = sizes[i][0];
            }else {
                smaller = sizes[i][1];
            }
            
            if(smaller>max_pair) {
                max_pair = smaller;
            }
        }
        
        answer = max_total * max_pair;
        return answer;
    }
}