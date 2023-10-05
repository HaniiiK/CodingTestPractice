import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] mx = {1, 0, -1, 0};
    static int[] my = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();

        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            board = new int[n][m];
            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            visited = new boolean[n][m];
            int houseCnt = 0;
            for(int i2 = 0; i2<n; i2++) {
                for(int j2 = 0; j2<m; j2++) {
                    if(board[i2][j2]==1 && !visited[i2][j2]) {
                        dfs(i2, j2);
                        houseCnt++;
                    }
                }
            }
            sb.append(houseCnt + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int newX = x+mx[i];
            int newY = y+my[i];
            if(newX>=0 && newX<n && newY>=0 && newY<m && !visited[newX][newY] && board[newX][newY]==1) {
                dfs(newX, newY);
            }
        }
    }

}