import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuffer sb = new StringBuffer();
        int tmp = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = N-1; j >= i+1; j--) {
                if (arr[j-1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
            sb.append(arr[i]+"\n");
        }
        sb.append(arr[N-1]+"\n");

        System.out.print(sb.toString());
    }
}