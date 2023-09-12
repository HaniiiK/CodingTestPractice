import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int answer = 0;

        while(true) {
            if(isPalindrome(N) && isPrime(N)) {
                answer = N;
                break;
            }
            N++;
        }
        if(N==1) {
            answer = 2;
        }

        System.out.println(answer);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int num) {
        String s = num+"";

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
                return false;
            }
        }

        return true;
    }
}