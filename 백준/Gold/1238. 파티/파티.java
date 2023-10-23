import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] list;
    static int[] answerTmp;
    static int[] answer;
    static int x;

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
        int n = Integer.parseInt(st.nextToken()); //마을 개수
        int m = Integer.parseInt(st.nextToken()); //방향 개수
        x = Integer.parseInt(st.nextToken()); //destination

        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, t));
        }

        answerTmp = new int[n+1];
        Arrays.fill(answerTmp, Integer.MAX_VALUE);
        answer = new int[n+1];

        //x -> 나
        answerTmp[x] = 0;
        dijkstra(x);
        for(int i=1; i<=n; i++) {
            answer[i] = answerTmp[i];
        }

        //나 -> x
        for(int i=1; i<=n; i++) {
            Arrays.fill(answerTmp, Integer.MAX_VALUE);
            dijkstra(i);
            answer[i] += answerTmp[x];
        }

        System.out.println(Arrays.stream(answer).max().getAsInt());
    }

    static private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            if(answerTmp[tmp.node] < tmp.distance) {
                continue;
            }

            for(int i=0; i<list[tmp.node].size(); i++) {
                int nextNode = list[tmp.node].get(i).node;
                int totalDistance = tmp.distance + list[tmp.node].get(i).distance;

                if(answerTmp[nextNode] > totalDistance) {
                    answerTmp[nextNode] = totalDistance;
                    pq.offer(new Node(nextNode, totalDistance));
                }
            }
        }
    }

}