import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static int[] time;

    static class Node implements Comparable<Node> {
        int v;
        int weight;
        public Node(int v, int weight) {
            this.v = v;
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
        int T = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); //의존성 개수
            int c = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터 번호

            graph = new ArrayList[n+1];
            for(int j=0; j<=n; j++) {
                graph[j] = new ArrayList<>();
            }
            time = new int[n+1];
            Arrays.fill(time, Integer.MAX_VALUE);
            time[c] = 0;

            for(int j=0; j<d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Node(a, s));
            }

            dijkstra(c);
            int cnt = 0;
            int max = 0;
            for(int j=1; j<=n; j++) {
                if(time[j]!=Integer.MAX_VALUE) {
                    cnt++;
                    max = Integer.max(max, time[j]);
                }
            }
            sb.append(cnt+" "+max+"\n");
        }
        System.out.print(sb.toString());
    }

    static private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node poll = pq.poll();

            if(time[poll.v] < poll.weight) {
                continue;
            }

            for(int i=0; i<graph[poll.v].size(); i++) {
                int nextNode = graph[poll.v].get(i).v;
                int totalTime = poll.weight + graph[poll.v].get(i).weight;
                if(time[nextNode] > totalTime) {
                    time[nextNode] = totalTime;
                    pq.offer(new Node(nextNode, totalTime));
                }
            }
        }
    }

}