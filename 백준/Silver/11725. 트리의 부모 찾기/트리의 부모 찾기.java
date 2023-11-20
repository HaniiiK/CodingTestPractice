import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static Queue<Integer> queue;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        queue = new LinkedList<>();
        visited = new boolean[n+1];
        answer = new int[n+1];

        queue.offer(1);
        bfs();

        for(int i=2; i<=n; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void bfs() {
        if (queue.isEmpty()) {
            return;
        }

        int poll = queue.poll();
        visited[poll] = true;

        for(int i=0; i<list[poll].size(); i++) {
            if(!visited[list[poll].get(i)]) {
                queue.offer(list[poll].get(i));
                answer[list[poll].get(i)] = poll;
                visited[list[poll].get(i)] = true;
            }
        }

        bfs();
    }
}