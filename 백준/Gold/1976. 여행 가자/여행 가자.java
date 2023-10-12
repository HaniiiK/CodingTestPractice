import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = i;
        }

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a==1) {
                    setUnion(i+1, j+1);
                }
            }
        }

        int[] ms = new int[m];
        String answer = "YES";
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++) {
            ms[i] = Integer.parseInt(st.nextToken());

            if(i==0) {
                continue;
            }
            if(getFind(ms[i])!=getFind(ms[i-1])) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
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