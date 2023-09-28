import java.util.*;

class Solution {
    static Queue<Node> queue;
    static boolean[] visited;
    static int answer;
    
    static class Node {
        private String word;
        private int cnt;
        
        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    } 
    
    public int solution(String begin, String target, String[] words) {
        queue = new LinkedList<>();
        visited = new boolean[words.length];
        
        answer = 0;
        queue.offer(new Node(begin, 0));
        bfs(words, target);
        
        return answer;
    }
    
    private void bfs(String[] words, String target) {
        if(queue.isEmpty()) {
            return;
        }
        
        Node tmp = queue.poll();
        if(tmp.word.equals(target)) {
            answer = tmp.cnt;
            return;
        }
        
        int sameWord;
        for(int i=0; i<words.length; i++) {
            if(visited[i]) {
                continue;
            }

            sameWord = 0;
            for(int j=0; j<words[i].length(); j++) {
                if(tmp.word.charAt(j)==words[i].charAt(j)) {
                    sameWord++;
                }
            }
            
            if(sameWord == words[i].length()-1) {
                visited[i] = true;
                queue.offer(new Node(words[i], tmp.cnt+1));
            }            
        }
        
        bfs(words, target);
    }
}