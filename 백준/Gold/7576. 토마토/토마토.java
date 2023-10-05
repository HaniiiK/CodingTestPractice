import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int answer;
    static int[] mx = {1, 0, -1, 0};
    static int[] my = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1) {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        answer = 0;
        bfs();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]==0) {
                    answer = -1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs() {
        if(queue.isEmpty()) {
            return;
        }

        int[] tmp = queue.poll();
        visited[tmp[0]][tmp[1]] = true;
        answer = tmp[2];

        for(int i=0; i<4; i++) {
            int newX = tmp[0]+mx[i];
            int newY = tmp[1]+my[i];
            if(newX>=0 && newY>=0 && newX<n && newY<m && board[newX][newY]!=-1 && !visited[newX][newY]) {
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY, tmp[2]+1});
                board[newX][newY] = 1;
            }
        }
        bfs();
    }

}