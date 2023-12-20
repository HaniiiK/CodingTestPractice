import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] score = new int[N];

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = score[0];

        if (N >= 2) {
            dp[1] = score[0] + score[1];
            if (N >= 3) {
                dp[2] = Math.max(score[0], score[1]) + score[2];

                for (int i = 3; i < N; i++) {
                    dp[i] = Math.max(score[i - 1] + dp[i - 3], dp[i - 2]) + score[i];
                }
            }
        }

        System.out.println(dp[N-1]);
    }
}