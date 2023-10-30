import java.io.*;
import java.util.*;

public class Main {
    static int n, m, start, end;
    static List<Node> graph;
    static int[] makeMoney;

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
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Node(a, b, c));
        }

        makeMoney = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            makeMoney[i] = Integer.parseInt(st.nextToken());
        }

        bellmanford();
    }

    static private void bellmanford() {
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MIN_VALUE);
        distance[start] = makeMoney[start];

        for (int i = 0; i < n*2; i++) {
            for (int j = 0; j < m; j++) {
                Node node = graph.get(j);
                if (distance[node.v] != Long.MIN_VALUE && distance[node.w] < distance[node.v] - node.weight + makeMoney[node.w]) {
                    distance[node.w] = distance[node.v]  - node.weight + makeMoney[node.w];
                    if(i>=n) {
                        distance[node.w] = Long.MAX_VALUE;
                    }
                }else if(distance[node.v] == Long.MAX_VALUE) {
                    distance[node.w] = Long.MAX_VALUE;
                }
            }
        }

        if (distance[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        }else if (distance[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        }else {
            System.out.println(distance[end]);
        }
    }
    
}