import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] pocket = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pocket[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i=N-1; i>=0; i--) {
            if(K == 0) {
                break;
            }
            if(K >= pocket[i]) {
                K = K - pocket[i];
                answer++;
                i++;
            }
        }

        System.out.println(answer);
    }

}