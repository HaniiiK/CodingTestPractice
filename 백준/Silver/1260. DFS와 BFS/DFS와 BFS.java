import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        int a, b;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N+1];

        dfs(V);

        System.out.println();
        for(int j=1; j<=N; j++) {
            visited[j] = false;
        }

        bfs(V);
    }

    public static void dfs(int idx) {
        System.out.print(idx+" ");
        visited[idx] = true;
        for(int i=0; i<list[idx].size(); i++) {
            if(!visited[list[idx].get(i)]) {
                dfs(list[idx].get(i));
            }
        }
    }

    public static void bfs(int idx) {
        System.out.print(idx+" ");
        visited[idx] = true;
        for(int i=0; i<list[idx].size(); i++) {
            if(!visited[list[idx].get(i)] && !queue.contains(list[idx].get(i))) {
                queue.add(list[idx].get(i));
            }
        }

        if (!queue.isEmpty()) {
            bfs(queue.poll());
        }
    }

}