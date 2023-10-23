import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] list;
    static int[] answer;

    static class Node implements Comparable<Node> {
        int node;
        int distance;
        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        answer = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        bfs(start);

        System.out.println(answer[end]);
    }

    static private void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        answer[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            if(answer[tmp.node] < tmp.distance) {
                continue;
            }

            for(int i=0; i<list[tmp.node].size(); i++) {
                int nextNode = list[tmp.node].get(i).node;
                int totalDistance = tmp.distance + list[tmp.node].get(i).distance;
                if(answer[nextNode] > totalDistance) {
                    answer[nextNode] = totalDistance;
                    pq.offer(new Node(nextNode, totalDistance));
                }
            }
        }

    }
}