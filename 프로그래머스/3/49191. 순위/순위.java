class Solution {
    public int solution(int n, int[][] results) {
        int[][] score = new int[n+1][n+1];
        
        //앞에 오는 인덱스가 이기면 1, 지면 -1
        for(int i=0; i<results.length; i++) {
            score[results[i][0]][results[i][1]] = 1;
            score[results[i][1]][results[i][0]] = -1;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(score[i][k]==1 && score[k][j]==1) {
                        score[i][j] = 1;
                    }else if(score[i][k]==-1 && score[k][j]==-1) {
                        score[i][j] = -1;
                    }
                }
            }
        }
        
        int answer = n;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) {
                    continue;
                }
                if(score[i][j]==0) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}