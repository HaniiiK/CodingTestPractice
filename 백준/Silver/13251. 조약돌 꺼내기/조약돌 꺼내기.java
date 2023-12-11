import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = 0;
        int[] s = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            N += s[i];
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        double a = 0, b = 0, tmp = 0;
        for (int i = 0; i < M; i++) {
            tmp = 1.0;
            for (int j = 0; j < K; j++) {
                tmp *= s[i] - j;
            }
            a += tmp;
        }

        b = 1.0;
        for (int i = 0; i < K; i++) {
            b *= N - i;
        }

        System.out.printf("%.16f", (double)(a/b));
    }
}