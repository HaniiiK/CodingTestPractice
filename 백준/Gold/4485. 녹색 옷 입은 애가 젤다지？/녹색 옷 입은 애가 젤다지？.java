import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static int[][] distance;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> answerList = new ArrayList<>();

        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0) {
                break;
            }

            board = new int[n][n];
            distance = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }

            dijkstra();
            answerList.add(distance[n-1][n-1]);
        }

        for(int i=1; i<=answerList.size(); i++) {
            System.out.println("Problem "+i+": "+answerList.get(i-1));
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[0][0] = board[0][0];
        pq.offer(new Node(0, 0, board[0][0]));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            for(int i=0; i<4; i++) {
                int newX = poll.x + moveX[i];
                int newY = poll.y + moveY[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && distance[poll.x][poll.y]+board[newX][newY] < distance[newX][newY]) {
                    distance[newX][newY] = distance[poll.x][poll.y]+board[newX][newY];
                    pq.offer(new Node(newX, newY, distance[poll.x][poll.y]+board[newX][newY]));
                }
            }
        }
    }
}