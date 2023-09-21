import java.util.*;

class Solution {
    static int answer;
    static Queue<int[]> queue;
    static boolean[] visited;
    
    public int solution(int x, int y, int n) {        
        answer = -1;
        queue = new LinkedList<>();
        visited = new boolean[1000001];
        
        queue.offer(new int[]{y, 0});
        bfs(x, n);

        return answer;
    }
    
    private void bfs(int x, int n) {
        if(queue.isEmpty()) {
            return;
        }
        
        int[] tmp = queue.poll();
//        System.out.println(tmp[0]+" "+tmp[1]);
        visited[tmp[0]] = true;
        
        if(tmp[0]==x) {
            answer = tmp[1];
            return;       
        }

        if(tmp[0]-n>=x && !visited[tmp[0]-n]) {
            queue.offer(new int[]{tmp[0]-n, tmp[1]+1});
        }
        if(tmp[0]%2==0 && tmp[0]/2>=x && !visited[tmp[0]/2]) {
            queue.offer(new int[]{tmp[0]/2, tmp[1]+1});
        }
        if(tmp[0]%3==0 && tmp[0]/3>=x && !visited[tmp[0]/3]) {
            queue.offer(new int[]{tmp[0]/3, tmp[1]+1});
        }
        
        bfs(x, n);
    }
}