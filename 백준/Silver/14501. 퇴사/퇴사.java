import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); //걸리는 기간
            P[i] = Integer.parseInt(st.nextToken()); //받을 수 있는 금액
        }

        int[] dp = new int[N+2];

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) { //마지막날+1일은 가능한거니까 N+1
                dp[i] = dp[i+1];
            }else {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[1]);
    }
}