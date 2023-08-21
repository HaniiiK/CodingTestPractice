import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        //첫번째 자리수
        dfs(1, 2);
        dfs(1, 3);
        dfs(1, 5);
        dfs(1, 7);
    }

    public static void dfs(int cnt, int num) {
        if (cnt == N) {
            if(isPrime(num)) {
                System.out.println(num);
            }

        }else {
            for(int i=1; i<=9; i+=2) {
                if(isPrime(num*10+i)) {
                    dfs(cnt+1, num*10+i);
                }
            }
        }

    }

    public static boolean isPrime(long num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for(long i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}