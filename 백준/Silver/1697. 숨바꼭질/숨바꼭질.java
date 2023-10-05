import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int answer;
    static Queue<int[]> queue;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        answer = 0;
        if(n>k) {
            answer = n-k;
        }else {
            queue = new LinkedList<>();
            queue.offer(new int[]{k, 0});
            visited[k] = true;
            bfs();
        }

        System.out.println(answer);
    }

    private static void bfs() {
        if (queue.isEmpty()) {
            return;
        }

        int[] tmp = queue.poll();
        visited[tmp[0]] = true;
        if(tmp[0]==n) {
            answer = tmp[1];
            return;
        }

        if(tmp[0]+1<=100000 && !visited[tmp[0]+1]) {
            queue.offer(new int[]{tmp[0]+1, tmp[1]+1});
        }
        if(tmp[0]-1>=0 && !visited[tmp[0]-1]) {
            queue.offer(new int[]{tmp[0]-1, tmp[1]+1});
        }
        if(tmp[0]%2==0 && !visited[tmp[0]/2]) {
            queue.offer(new int[]{tmp[0]/2, tmp[1]+1});
        }

        bfs();
    }

}