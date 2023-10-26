import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] board;
    static int[][] distance;
    static Queue<int[]> queue;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        distance = new int[n][n];
        queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<s.length(); j++) {
                if (s.charAt(j)=='1') {
                    board[i][j] = 1;
                }else {
                    board[i][j] = 0;
                }
            }
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[0][0] = 0;
        queue.offer(new int[]{0, 0});
        bfs();

        System.out.println(distance[n-1][n-1]);
    }

    static private void bfs() {
        if(queue.isEmpty()) {
            return;
        }

        int[] poll = queue.poll();
        int x = poll[0];
        int y = poll[1];

        for(int i=0; i<4; i++) {
            int newX = x+moveX[i];
            int newY = y+moveY[i];
            if(newX>=0 && newX<n && newY>=0 && newY<n && distance[x][y] < distance[newX][newY]) {
                if(board[newX][newY]==1) {
                    distance[newX][newY] = distance[x][y];
                }else {
                    distance[newX][newY] = distance[x][y]+1;
                }
                queue.offer(new int[]{newX, newY});
            }
        }

        bfs();
    }
}