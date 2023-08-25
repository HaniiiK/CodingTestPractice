import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] mx = new int[]{1, 0, -1, 0};
    static int[] my = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        String s;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            for(int j=0; j<M; j++) {
                board[i][j] = s.charAt(j)-'0';
            }
        }

        visited = new boolean[N][M];
        queue = new LinkedList<>();

        queue.offer(new int[]{0,0,1});
        bfs();
    }

    public static void bfs() {
        int x, y, cnt;
        int[] tmp = queue.poll();
        x = tmp[0];
        y = tmp[1];
        cnt = tmp[2];
        visited[x][y] = true;

        if(x==N-1 && y==M-1) {
            System.out.println(cnt);
            return;
        }

        for(int i=0; i<4; i++) {
            if((x+mx[i]>=0 && x+mx[i]<N) && (y+my[i]>=0 && y+my[i]<M) && board[x+mx[i]][y+my[i]]==1 && !visited[x+mx[i]][y+my[i]]) {
                queue.offer(new int[]{x+mx[i], y+my[i], cnt+1});
                visited[x+mx[i]][y+my[i]] = true;
            }
        }

        bfs();
    }
}