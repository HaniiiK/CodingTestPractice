import java.util.*;

class Solution {
    static List<Node>[] list;
    static int[] distance;
    static int answer;

    public static class Node implements Comparable<Node> {
        int spot;
        int distance;
        public Node(int spot, int distance) {
            this.spot = spot;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<road.length; i++) {
            list[road[i][0]].add(new Node(road[i][1], road[i][2]));
            list[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        distance = new int[N+1];
        dijkstra();
        
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(distance[i]<=K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            int node = tmp.spot;
            int dist = tmp.distance;
            
            for(int i=0; i<list[node].size(); i++) {
                int nextNode = list[node].get(i).spot;
                int totalDistance = dist + list[node].get(i).distance;
                
                if(distance[nextNode] > totalDistance) {
                    distance[nextNode] = totalDistance;
                    pq.offer(new Node(nextNode, totalDistance));
                }                
            }
        }
    }
    
}