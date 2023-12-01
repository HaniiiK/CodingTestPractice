import java.io.*;
import java.util.*;

public class Main {
    static int[] inOrder, inIdx, postOrder;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        inOrder = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        postOrder = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        inIdx = new int[n+1];
        for (int i = 1; i <= n; i++) {
            inIdx[inOrder[i]] = i;
        }

        sb = new StringBuilder();
        solve(1, n, 1, n);

        System.out.println(sb.toString());
    }

    private static void solve(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postOrder[postEnd];
        int idx = inIdx[root];
        sb.append(root+" ");

        int len = idx - inStart;
        solve(inStart, idx-1, postStart, postStart+len-1); //left
        solve(idx+1, inEnd, postStart+len, postEnd-1); //right
    }
}