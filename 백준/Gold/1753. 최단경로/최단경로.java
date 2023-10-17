import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Node>[] list;
    static int[] answer;

    static class Node implements Comparable<Node> {
        int node;
        int distance;

        public Node(int node, int weight) {
            this.node = node;
            this.distance = weight;
        }
        public int getNode() {
            return node;
        }
        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance > o.distance) {
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점
        int m = Integer.parseInt(st.nextToken()); //간선

        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Node(w, v));
        }

        answer = new int[n+1];
        for(int i=1; i<=n; i++) {
            answer[i] = -1;
        }
        answer[start] = 0;

        dijkstra1(start);

        for(int i=1; i<=n; i++) {
            if(answer[i]==-1) {
                System.out.println("INF");
            }else {
                System.out.println(answer[i]);
            }
        }
    }

    static void dijkstra1(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            for(Node node : list[poll.getNode()]) {
                int nextIdx = node.getNode();
                int nextDistance = answer[poll.getNode()] + node.getDistance();
                if(answer[nextIdx]==-1 || answer[nextIdx] > nextDistance) {
                    answer[nextIdx] = nextDistance;
                    pq.offer(new Node(nextIdx, nextDistance));
                }
            }
        }
    }

}