import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {        
        int[][] visited = new int[n][m];
        if(puddles[0].length!=0) {
            for(int[] puddle : puddles) {
                visited[puddle[1]-1][puddle[0]-1] = -1;
            }
        }
        
        visited[0][0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j]!=-1) {
                    if(i>=1 && visited[i-1][j]!=-1) {
                        visited[i][j] += visited[i-1][j];
                    }
                    if(j>=1 && visited[i][j-1]!=-1) {
                        visited[i][j] += visited[i][j-1];
                    }
                    visited[i][j] %= 1000000007;
                }
            }
        }
        int answer = visited[n-1][m-1];
        
        return answer;
    }    
}