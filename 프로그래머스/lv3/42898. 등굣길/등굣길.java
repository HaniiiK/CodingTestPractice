import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {        
        int[][] visited = new int[n][m];
        if(puddles[0].length!=0) {
            for(int[] puddle : puddles) {
                visited[puddle[1]-1][puddle[0]-1] = -1;
            }
        }
        
        boolean waterExistX = false;
        boolean waterExistY = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0) {
                    if(visited[i][j]==-1) {
                        waterExistX = true;
                    }
                    if(visited[i][j]!=-1 && waterExistX) {
                        visited[i][j] = 0;
                    }else if(visited[i][j]!=-1 && !waterExistX) {
                        visited[i][j] = 1;
                    }
                }else if(j==0) {
                    if(visited[i][j]==-1) {
                        waterExistY = true;
                    }
                    if(visited[i][j]!=-1 && waterExistY) {
                        visited[i][j] = 0;
                    }else if(visited[i][j]!=-1 && !waterExistY)  {
                        visited[i][j] = 1;
                    }
                }else {
                    if(visited[i][j]!=-1) {
                        int sum = 0;
                        if(visited[i-1][j]!=-1) {
                            sum += visited[i-1][j];
                        }
                        if(visited[i][j-1]!=-1) {
                            sum += visited[i][j-1];
                        }
                        visited[i][j] = sum%1000000007;
                    }
                }
            }
        }
        int answer = (visited[n-1][m-1]);
        
        return answer;
    }    
}