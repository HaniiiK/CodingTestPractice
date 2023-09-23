class Solution {
    public int[] solution(int n) {        
        //행별로 열 생성
        int[][] tmp = new int[n][];
        for(int i=0; i<n; i++) {
            tmp[i] = new int[i+1];
        }

        int[] answer = new int[(int)((1+n)*(n/(double)2))];
        int num = 1;
        int x = 0;
        int y = 0;
        int maxX = n-1;
        int minY = 0;
        
        while(true) {
            if(x<maxX && y==minY) {
                tmp[x++][y] = num++;
                if(x==maxX) {
                    minY++;
                }
            }else if(x==maxX && y<tmp[x].length-minY) {
                tmp[x][y++] = num++;
            }else if(y==tmp[x].length-minY) {
                tmp[x--][y--] = num++;
                if(y==minY) {
                    maxX--;
                }
            }
            
            if(num>answer.length) {
                break;
            }
        }
        
        //정답 추출
        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<tmp[i].length; j++) {
                answer[idx++] = tmp[i][j];
            }
        }

        return answer;
    }
}