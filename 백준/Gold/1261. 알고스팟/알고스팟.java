import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int answer;

    static class Node {
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<n; j++) {
                board[i][j] = s.charAt(j)-'0';
            }
        }

        answer = Integer.MAX_VALUE;
        bfs();

        System.out.println(answer);
    }

    static private void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));

        visited[0][0] = true;
        pq.offer(new Node(0, 0, 0));

        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            visited[poll.x][poll.y] = true;
            if(poll.x==m-1 && poll.y==n-1) {
                answer = Math.min(answer, poll.cnt);
            }

            for(int i=0; i<4; i++) {
                int newX = poll.x + moveX[i];
                int newY = poll.y + moveY[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.offer(new Node(newX, newY, poll.cnt + board[newX][newY]));
                }
            }
        }
    }
}