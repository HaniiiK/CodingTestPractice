import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static PriorityQueue<Node> pq;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점 개수
        m = Integer.parseInt(st.nextToken()); //간선 개수

        pq = new PriorityQueue<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, c));
        }

        parent = new int[n+1];
        for(int i=0; i<=n; i++) {
            parent[i] = i;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            //서로 부모 노드가 다르면 -> 합침
            if(find(tmp.v) != find(tmp.w)) {
                union(tmp.v, tmp.w);
                sum += tmp.weight;
            }
        }

        System.out.println(sum);
    }

    private static void union(int v, int w) {
        int p1 = find(v);
        int p2 = find(w);

        if(p1<p2) {
            parent[p2] = p1;
        }else {
            parent[p1] = p2;
        }
    }

    private static int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}