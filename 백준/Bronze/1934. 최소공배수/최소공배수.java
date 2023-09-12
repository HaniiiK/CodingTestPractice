import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(A*B/gcd(B, A)+"\n");
        }

        System.out.println(sb.toString());
    }

    public static int gcd(int a, int b) {
        if(b==0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }

}