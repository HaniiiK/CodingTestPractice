import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static Queue<Integer> queue;
    static boolean[] visited;

    static int[] parent;
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        parent = new int[n];
        degree = new int[n];

        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) {
                parent[i] = i;
            }else {
                parent[i] = a;
                degree[a]++;
                list[a].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int deleteNode = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new boolean[n];

        queue.offer(deleteNode);
        bfs();

        int sum = 0;
        for(int i=0; i<n; i++) {
            if(degree[i]==0) {
                sum++;
            }
        }

        System.out.println(sum);
    }

    private static void bfs() {
        if (queue.isEmpty()) {
            return;
        }

        int poll = queue.poll();
        visited[poll] = true;
        degree[parent[poll]]--;
        degree[poll] = -1;

        for(int i=0; i<list[poll].size(); i++) {
            if(!visited[list[poll].get(i)]) {
                queue.offer(list[poll].get(i));
                degree[parent[list[poll].get(i)]]--;
                degree[list[poll].get(i)] = -1;
                visited[list[poll].get(i)] = true;
            }
        }

        bfs();
    }
}