import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        long[] remainders = new long[M];
        long sum = 0;
        long answer = 0L;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum%M;
            if(arr[i]==0) {
                answer++;
            }
            remainders[(int)arr[i]]++;
        }

        for(int i=0; i<M; i++) {
            if(remainders[i]>1) {
                answer += (remainders[i] * (remainders[i]-1))/2;
            }
        }

        System.out.println(answer);
    }
}