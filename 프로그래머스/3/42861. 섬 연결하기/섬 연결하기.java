import java.util.*;

class Solution {    
    
    static int[] parent;
    
    static class Node implements Comparable<Node> {
        int v;
        int w;
        int weight;
        public Node(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i=0; i<costs.length; i++) {
            int v = costs[i][0];
            int w = costs[i][1];
            int weight = costs[i][2];
            
            pq.offer(new Node(v, w, weight));
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            
            if(find(tmp.v) != find(tmp.w)) {
                union(tmp.v, tmp.w);
                answer += tmp.weight;
            }            
        }
        
        return answer;
    }
    
    private static int find(int v) {
        if(parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }
    
    private static void union(int v, int w) {
        int p1 = parent[v];
        int p2 = parent[w];
        
        if(p1<p2) {
            parent[p2] = p1;
        }else {
            parent[p1] = p2;
        }
    }
}