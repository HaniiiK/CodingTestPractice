import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static StringBuilder sb;
    static boolean[] visited;
    static int answer;

    static class Node {
        int w;
        int weight;
        public Node(int w, int weight) {
            this.w = w;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        //쌍 입력받기
        sb = new StringBuilder();

        int[][] pair = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pair[i][0] = Integer.parseInt(st.nextToken());
            pair[i][1] = Integer.parseInt(st.nextToken());

            answer = Integer.MAX_VALUE;
            visited = new boolean[n+1];
            bfs(pair[i][0], pair[i][1]);
            sb.append(answer + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[]{start, 0});
        visited[start] = true;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            visited[poll[0]] = true;
            if (poll[0] == end) {
                answer = Math.min(answer, poll[1]);
            }

            for(int i=0; i<list[poll[0]].size(); i++) {
                if(!visited[list[poll[0]].get(i).w]) {
                    pq.offer(new int[]{list[poll[0]].get(i).w, poll[1] + list[poll[0]].get(i).weight});
                    visited[list[poll[0]].get(i).w] = true;
                }
            }
        }
    }
}