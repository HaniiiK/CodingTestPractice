import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long answer = 0;
        if(a>b) {
            answer = gcd(a, b);
        }else {
            answer = gcd(b, a);
        }

        StringBuffer sb = new StringBuffer();
        for(; answer>0; answer--) {
            sb.append("1");
        }

        System.out.println(sb.toString());
    }

    public static long gcd(long a, long b) {
        if(b==0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }

}