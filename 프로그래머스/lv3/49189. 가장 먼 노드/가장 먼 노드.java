import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static Queue<int[]> queue;
    static int max;
    static int answer;
    
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        
        visited = new boolean[n];
        queue = new LinkedList<>();
        
        for(int i=0; i<edge.length; i++) {
            list[edge[i][0]-1].add(edge[i][1]-1);
            list[edge[i][1]-1].add(edge[i][0]-1);
        }
        
        max = 1;
        answer = 0;
        queue.offer(new int[]{0, 0});
        bfs();
                
        return answer;
    }
    
    private void bfs() {
        if(queue.isEmpty()) {
            return;
        }
        
        int[] tmp = queue.poll();
        visited[tmp[0]] = true;
        if(tmp[1]>max) {
            max = tmp[1];
            answer = 1;
        }else if(tmp[1]==max) {
            answer++;
        }
        
        for(int i=0; i<list[tmp[0]].size(); i++) {
            if(!visited[list[tmp[0]].get(i)]) {
                visited[list[tmp[0]].get(i)] = true;
                queue.offer(new int[]{list[tmp[0]].get(i), tmp[1]+1});
            }
        }
        
        bfs();
    }
    
    private void dfs(int idx, int cnt) {
        visited[idx] = true;
        
        if(cnt>max) {
            max = cnt;
            answer = 1;
        }else if(cnt==max) {
            answer++;
        }
        
        for(int i=0; i<list[idx].size(); i++) {
            if(!visited[list[idx].get(i)]) {
                visited[list[idx].get(i)] = true;
                dfs(list[idx].get(i), cnt+1);
            }
        }
        
    }
}