import java.io.*;
import java.util.*;

class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] answerArr;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a-1].add(b-1);
        }

        answerArr = new int[n];

        queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            queue.offer(i);
            bfs();
        }

        int max = Arrays.stream(answerArr).max().getAsInt();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++) {
            if(answerArr[i]==max) {
                sb.append(i+1+" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static void bfs() {
        if(queue.isEmpty()) {
            return;
        }

        int tmp = queue.poll();
        visited[tmp] = true;
        answerArr[tmp]++;
        for(int i=0; i<list[tmp].size(); i++) {
            if(!visited[list[tmp].get(i)]) {
                visited[list[tmp].get(i)] = true;
                queue.offer(list[tmp].get(i));
            }
        }

        bfs();
    }

}