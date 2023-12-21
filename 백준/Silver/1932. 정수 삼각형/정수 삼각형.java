import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][];
        for (int i = 0; i < N; i++) {
            dp[i] = new int[i+1];
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int tmp = dp[i][j];

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + tmp;
                } else if (j == dp[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + tmp;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + tmp;
                }
            }
        }

        Arrays.sort(dp[N - 1]);
        System.out.println(dp[N - 1][N - 1]);
    }
}