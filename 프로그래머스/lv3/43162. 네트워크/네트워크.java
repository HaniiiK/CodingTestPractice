import java.util.*;

class Solution {
    
    static List<Integer>[] list;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i!=j && computers[i][j]==1) {
                    list[i].add(j);
                }
            }
        }
        
        visited = new boolean[n];
        int answer = 1;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);    
                
                for(int j=0; j<n; j++) {
                    if(!visited[j]) {
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(int idx) {
        visited[idx] = true;
        
        for(int i=0; i<list[idx].size(); i++) {
            if(!visited[list[idx].get(i)]) {
                visited[list[idx].get(i)] = true;
                dfs(list[idx].get(i));
            }
        }
    }
}