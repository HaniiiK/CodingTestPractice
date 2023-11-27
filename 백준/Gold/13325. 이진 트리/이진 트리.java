import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k+1][];
        for(int i=0; i<=k; i++) {
            int tmp = (int)Math.pow(2, i);
            arr[i] = new int[tmp];
        }

        int input = (int)Math.pow(2, k+1) - 2;
        int idx1 = 1, idx2 = 0;
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<input; j++) {
            int a = Integer.parseInt(st.nextToken());
            arr[idx1][idx2++] = a;
            if (idx2 == arr[idx1].length) {
                idx1++;
                idx2 = 0;
            }
        }

        //0번째 줄부터 최대값 찾기
        answer = 0;
        dfs(0, 0);

        System.out.println(answer);
    }

    private static int dfs(int startRow, int col) {
        if (startRow == k) {
            answer += arr[startRow][col];
            return arr[startRow][col];
        }

        int left = dfs(startRow+1, col*2);
        int right = dfs(startRow+1, col*2+1);

        answer += arr[startRow][col] + Math.abs(left - right);
        return arr[startRow][col] + Math.max(left, right);
    }
}