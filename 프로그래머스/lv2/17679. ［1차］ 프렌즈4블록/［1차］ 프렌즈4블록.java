class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        Character[][] brd = new Character[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                brd[i][j] = board[i].charAt(j);
            }
        }
        
        boolean havePairs;
        while(true) {
            havePairs = false;
            boolean[][] visited = new boolean[m][n];

            //짝 찾기
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(brd[i][j]!=null && brd[i][j] == brd[i][j+1] && brd[i][j] == brd[i+1][j] && brd[i][j] == brd[i+1][j+1]) {
                        havePairs = true;
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;
                    }
                }
            }
            
            if(!havePairs) {
                break;
            }

            //자리 옮기기
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(brd[i][j]!=null && visited[i][j]) {
                        answer++;
                        int nowX = i;
                        int preX = i-1;
                        while(true) {
                            if(preX<0) {
                                brd[nowX][j] = null;
                                break;
                            }
                            brd[nowX][j] = brd[preX][j];
                            nowX--;
                            preX--;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}