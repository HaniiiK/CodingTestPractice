import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int answer = binSearch(arr1, num);
            if(answer==-1) {
                sb.append("0\n");
            }else {
                sb.append("1\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static int binSearch(int[] a, int key) {
        int pl = 0;
        int pr = N-1;

        do{
            int pc = (pl + pr) /2;
            if (a[pc] == key) {
                return pc;
            } else if (a[pc] < key) {
                pl = pc+1;
            }else {
                pr = pc-1;
            }
        }while(pl<=pr);

        return -1;
    }

}