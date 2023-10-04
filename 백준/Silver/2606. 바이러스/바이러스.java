import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[n];
        queue = new LinkedList<>();

        queue.offer(0);
        bfs();

        System.out.println(cnt-1);
    }

    private static void bfs() {
        if (queue.isEmpty()) {
            return;
        }

        int num = queue.poll();
        cnt++;
        visited[num] = true;

        for(int i=0; i<list[num].size(); i++) {
            if(!visited[list[num].get(i)]) {
                queue.offer(list[num].get(i));
                visited[list[num].get(i)] = true;
            }
        }

        bfs();
    }

}