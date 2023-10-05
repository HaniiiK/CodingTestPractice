import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] house;
    static boolean[][] visited;
    static int cnt;
    static int[] mx = {1, 0, -1, 0};
    static int[] my = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        String[] input = new String[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = st.nextToken();
        }

        house = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                house[i][j] = input[i].charAt(j)-'0';
            }
        }

        int houseCnt = 0;
        List<Integer> answerList = new ArrayList<>();

        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(house[i][j]==1 && !visited[i][j]) {
                    cnt = 1;
                    dfs(i, j);
                    houseCnt++;
                    answerList.add(cnt);
                }
            }
        }
        Collections.sort(answerList);

        System.out.println(houseCnt);
        for(int i=0; i<answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int newX = x+mx[i];
            int newY = y+my[i];
            if(newX>=0 && newX<n && newY>=0 && newY<n && !visited[newX][newY] && house[newX][newY]==1) {
                cnt++;
                dfs(newX, newY);
            }
        }

    }

}