import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Node> graph;

    static class Node {
        int v;
        int w;
        int weight;
        public Node(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Node(a, b, c));
        }

        bellmanford(1);
    }

    static private boolean bellmanford(int start) {
        long[] distance = new long[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node node = graph.get(j);

                if (distance[node.v] != Integer.MAX_VALUE && distance[node.w] > distance[node.v] + node.weight) {
                    distance[node.w] = distance[node.v] + node.weight;
                }
            }
        }

        for(int i=0; i<m; i++) {
            Node node = graph.get(i);

            if (distance[node.v] != Integer.MAX_VALUE && distance[node.w] > distance[node.v] + node.weight) {
                System.out.println("-1");
                return false;
            }
        }

        for(int i=2; i<distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("-1");
            }else {
                System.out.println(distance[i]);
            }
        }

        return true;
    }
}