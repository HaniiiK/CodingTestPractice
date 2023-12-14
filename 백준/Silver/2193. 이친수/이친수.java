import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println("1");
        } else {
            long[] dp = new long[N+1];
            dp[1] = dp[2] = 1;

            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i-2] + dp[i-1];
            }

            System.out.println(dp[N]);
        }
    }
}