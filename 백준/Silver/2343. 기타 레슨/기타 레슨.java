import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binSearch(max, 1000000000));
    }

    public static int binSearch(int left, int right) {
        int pl = left;
        int pr = right;
        int pc;
        int sum;
        int cnt;

        do{
            pc = (pl + pr) /2;
            cnt = 1;
            sum = 0;
            for(int i=0; i<N; i++) {
                sum += arr[i];
                if(sum > pc) {
                    sum = arr[i];
                    cnt++;
                }
            }

            if(cnt > M) {
                pl = pc + 1;
            }else {
                pr = pc - 1;
            }
        }while(pl<=pr);

        return pl;
    }

}