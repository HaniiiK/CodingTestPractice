import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = i;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0) {
                setUnion(b, c);
            }else if(a==1) {
                if(getFind(b)==getFind(c)) {
                    sb.append("YES\n");
                }else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    private static void setUnion(int a, int b) {
        int x = getFind(a);
        int y = getFind(b);
        if(x==y) {
            return;
        }
        arr[y] = x;
    }

    private static int getFind(int a) {
        if(a==arr[a]) {
            return a;
        }
        int ret = getFind(arr[a]);
        arr[a] = ret;
        return arr[a];
    }

}