import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static List<Node>[] list;
    static List<PriorityQueue<Integer>> answerList;

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
        n = Integer.parseInt(st.nextToken()); //도시 개수
        int m = Integer.parseInt(st.nextToken()); //도로 개수
        k = Integer.parseInt(st.nextToken()); //k번째 최단경로

        list = new ArrayList[n+1];
        answerList = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
            answerList.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }
        answerList.get(1).offer(0);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, t));
        }

        dijkstra(1);

        for(int i=1; i<=n; i++) {
            if(answerList.get(i).size() < k) {
                System.out.println("-1");
            }else {
                System.out.println(answerList.get(i).peek());
            }
        }
    }

    static private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            for(int i=0; i<list[tmp.node].size(); i++) {
                int nextNode = list[tmp.node].get(i).node;
                int totalDistance = tmp.distance + list[tmp.node].get(i).distance;

                if(answerList.get(nextNode).size() < k) {
                    answerList.get(nextNode).offer(totalDistance);
                    pq.offer(new Node(nextNode, totalDistance));
                }else if(answerList.get(nextNode).peek() > totalDistance) {
                    answerList.get(nextNode).poll();
                    answerList.get(nextNode).offer(totalDistance);
                    pq.offer(new Node(nextNode, totalDistance));
                }
            }
        }
    }

}