import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 2;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
        }

        System.out.println(dp[N]);
    }
}