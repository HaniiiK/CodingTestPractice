class Solution {
    
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        for(int i=0; i<dungeons.length; i++) {
            if(k>=dungeons[i][0]) {
                visited[i] = true;
                dfs(i, k-dungeons[i][1], dungeons, 1);            
                visited[i] = false;
            }
        }
        
        return answer;
    }
    
    static private void dfs(int idx, int remain, int[][] dungeons, int cnt) {
        answer = Math.max(answer, cnt);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && remain>=dungeons[i][0]) {
                visited[i] = true;
                remain -= dungeons[i][1];
                dfs(i, remain, dungeons, cnt+1);
                remain += dungeons[i][1];
                visited[i] = false;
            }
        }
    }
    
}