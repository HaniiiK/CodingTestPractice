import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long answer = n;

        for(long i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) {
                answer = answer/i*(i-1);
            }
            while (n % i == 0) {
                n /= i;
            }
        }

        if(n!=1) {
            answer = answer/n*(n-1);
        }

        System.out.println(answer);
    }

}