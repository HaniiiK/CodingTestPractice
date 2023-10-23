import java.io.*;
import java.util.*;

public class Main {

    static int[] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        queue.offer(new int[]{k, 0});
        answer = 0;
        bfs();

        System.out.println(answer);
    }

    static private void bfs() {
        if(queue.isEmpty()) {
            return;
        }

        int[] poll = queue.poll();
        if(poll[0]==n) {
            answer = poll[1];
            return;
        }
        visited[poll[0]] = poll[1];

        if(poll[0]%2==0 && poll[0]/2>=0 && visited[poll[0]/2] > poll[1]) {
            queue.offer(new int[]{poll[0]/2, poll[1]});
        }
        if(poll[0]+1<=100000 && visited[poll[0]+1] > poll[1]+1) {
            queue.offer(new int[]{poll[0]+1, poll[1]+1});
        }
        if(poll[0]-1>=0 && visited[poll[0]-1] > poll[1]+1) {
            queue.offer(new int[]{poll[0]-1, poll[1]+1});
        }

        bfs();
    }

}