import java.util.*;

class Solution {
    static Queue<int[]> queue;
    static int answer;
    static int n, m;
    static boolean[][] visited;
    static int[] mx = new int[]{1, 0, -1, 0};
    static int[] my = new int[]{0, 1, 0, -1};    
        
    public int solution(int[][] maps) {
        answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];        
        
        queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        bfs(maps);
        
        return answer;
    }
    
    public static void bfs(int[][] maps) {
        if(queue.isEmpty()) {
            answer = -1;
            return;
        }
        
        int[] info = queue.poll();
        int x = info[0];
        int y = info[1];
        int cnt = info[2];        
        
        if(x==n-1 && y==m-1) {
            answer = cnt;
            return;
        }
        visited[x][y] = true;        
        
        int xIdx = 0;
        int yIdx = 0;
        for(int i=0; i<4; i++) {
            xIdx = x+mx[i];
            yIdx = y+my[i];
            if((xIdx>=0 && xIdx<n) && (yIdx>=0 && yIdx<m) && maps[xIdx][yIdx]==1 && !visited[xIdx][yIdx]) {
                visited[xIdx][yIdx] = true;
                queue.offer(new int[]{xIdx, yIdx, cnt+1});
            }
        }
        
        bfs(maps);
    }
    
}